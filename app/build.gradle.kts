plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.testprojectincompany"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testprojectincompany"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    kapt {
        correctErrorTypes = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
}

dependencies {
    // Jetpack Compose
    platform("androidx.compose:compose-bom:2022.10.00")
    implementation("androidx.compose.ui:ui-android:1.5.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    platform("org.jetbrains.kotlin:kotlin-bom:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.4.3")
    implementation("androidx.activity:activity-compose:1.5.1")

    // Dagger 2
    implementation("com.google.dagger:dagger:${rootProject.extra["daggerVersion"] as String}")
    kapt("com.google.dagger:dagger-compiler:${rootProject.extra["daggerVersion"] as String}")
    implementation("javax.inject:javax.inject:1")

    // Flexbox
    implementation("com.google.android.flexbox:flexbox:${rootProject.extra["flexBoxVersion"] as String}")

    // Glide
    implementation("com.github.bumptech.glide:glide:${rootProject.extra["glideVersion"] as String}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${rootProject.extra["retrofitVersion"] as String}")
    implementation("com.squareup.retrofit2:converter-gson:${rootProject.extra["retrofitVersion"] as String}")

    // Dots indicator
    implementation("com.tbuonomo:dotsindicator:${rootProject.extra["dotsIndicatorVersion"] as String}")

    // Navigation
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-fragment-ktx:${rootProject.extra["navigationVersion"] as String}")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-common-ktx:${rootProject.extra["navigationVersion"] as String}")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
