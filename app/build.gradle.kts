plugins {
    id("com.android.application")
}

android {
    namespace = "com.qicai.lianzhu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.qicai.lianzhu"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release { isMinifyEnabled = false }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
// 没有任何第三方依赖，纯系统 WebView
