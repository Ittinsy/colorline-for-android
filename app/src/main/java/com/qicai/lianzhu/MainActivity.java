package com.qicai.lianzhu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private WebView web;

    /** 给网页用的“第二份存档”：和 localStorage 双保险，写进应用自己的 SharedPreferences。 */
    private class Store {
        private final SharedPreferences sp = getSharedPreferences("qicai", MODE_PRIVATE);
        @JavascriptInterface public String get() { return sp.getString("save", ""); }
        @JavascriptInterface public void set(String s) { sp.edit().putString("save", s).apply(); }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(this);
        web.setBackgroundColor(0xFFF0F0F0);
        setContentView(web);

        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);       // localStorage
        s.setSupportZoom(false);
        s.setBuiltInZoomControls(false);
        s.setTextZoom(100);                 // 不跟随系统字体放大，避免排版被撑坏
        s.setAllowFileAccess(true);

        web.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        web.setLongClickable(false);
        web.setOnLongClickListener(v -> true);
        web.setHapticFeedbackEnabled(false);
        web.setWebChromeClient(new WebChromeClient());
        web.addJavascriptInterface(new Store(), "AndroidStore");
        web.loadUrl("file:///android_asset/index.html");
    }

    @Override protected void onPause()   { super.onPause();  if (web != null) web.onPause(); }
    @Override protected void onResume()  { super.onResume(); if (web != null) web.onResume(); }
    @Override protected void onDestroy() { if (web != null) { web.destroy(); web = null; } super.onDestroy(); }
}
