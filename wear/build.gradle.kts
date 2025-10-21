plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.strivesync.health.wear"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.strivesync.health.wear"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    
    kotlinOptions {
        jvmTarget = "1.8"
    }
    
    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

dependencies {
    // Wear OS
    implementation("androidx.wear:wear:1.3.0")
    
    // Compose for Wear OS
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.wear.compose:compose-material:1.2.1")
    implementation("androidx.wear.compose:compose-foundation:1.2.1")
    implementation("androidx.wear.compose:compose-navigation:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview")
    
    // Activity
    implementation("androidx.activity:activity-compose:1.8.1")
    
    // Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    
    // Health Services
    implementation("androidx.health:health-services-client:1.0.0-rc02")
    
    // Complications
    implementation("androidx.wear.watchface:watchface-complications-data-source-ktx:1.2.0")
    
    // Horologist for enhanced features
    implementation("com.google.android.horologist:horologist-compose-layout:0.5.11")
    implementation("com.google.android.horologist:horologist-compose-material:0.5.11")
    
    // Testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
}

