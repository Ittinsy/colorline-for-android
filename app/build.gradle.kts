plugins {
    id("com.android.application")
}

android {
    namespace = "com.color.line7"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.color.line7"
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
