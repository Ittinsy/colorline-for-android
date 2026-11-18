# 七彩连珠 Android 工程（WebView 套壳，纯离线）

游戏本体：app/src/main/assets/index.html（以后改玩法/界面只改这个文件）。

## 方式 A：Android Studio
1. File → Open，选这个文件夹，等 Gradle 同步（首次要下载 Gradle 和 Android SDK 34，按提示点 Install/OK）。
2. 菜单 Build → Build Bundle(s) / APK(s) → Build APK(s)。
3. 完成后点右下角 locate，文件在 app/build/outputs/apk/debug/app-debug.apk。
4. 传到手机安装（需允许“安装未知来源应用”）。

## 方式 B：GitHub Actions（不用装任何东西）
1. 新建一个仓库，把本文件夹所有内容传上去（注意 .github 文件夹也要在）。
2. 仓库 Actions 页 → Build APK → Run workflow（推送到 main 也会自动跑）。
3. 跑完（约 3~5 分钟）在该次运行页面底部 Artifacts 下载 qicai-apk，解压得到 app-debug.apk。
