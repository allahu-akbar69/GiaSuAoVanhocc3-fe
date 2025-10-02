plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.services)
}

import java.util.Properties

// Load local secrets from secrets.properties (ignored by Git)
val secretsProps = Properties().apply {
    val f = rootProject.file("secrets.properties")
    if (f.exists()) f.inputStream().use { load(it) }
}

android {
    namespace = "com.example.giasuaovanhocc3"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.giasuaovanhocc3"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "API_BASE_URL", "\"http://10.0.2.2:8080\"")
        // Inject sensitive IDs via BuildConfig/manifest placeholders
        buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", "\"${secretsProps.getProperty("GOOGLE_WEB_CLIENT_ID", "")}\"")
        manifestPlaceholders["facebookAppId"] = secretsProps.getProperty("FACEBOOK_APP_ID", "")
        manifestPlaceholders["facebookClientToken"] = secretsProps.getProperty("FACEBOOK_CLIENT_TOKEN", "")
        // Derive fb login scheme from app id (e.g., fb123456789)
        val fbAppId = secretsProps.getProperty("FACEBOOK_APP_ID", "")
        manifestPlaceholders["facebookScheme"] = if (fbAppId.isNotEmpty()) "fb$fbAppId" else ""
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
    }
    packaging {
        resources {
            excludes += "META-INF/native-image/**"
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    coreLibraryDesugaring(libs.desugar)

    // Firebase BOM - manages all Firebase library versions
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)

    // Google Sign-In
    implementation(libs.play.services.auth)

    // Facebook SDK
    implementation(libs.facebook.android.sdk)
}