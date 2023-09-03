plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.testprojectincompany"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.testprojectincompany"
        minSdk = 26
        targetSdk = 33
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
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    // Dagger 2
    implementation("com.google.dagger:dagger:2.43.2")
    kapt("com.google.dagger:dagger-compiler:2.43.2")
    implementation("javax.inject:javax.inject:1")

    // Flexbox
    implementation("com.google.android.flexbox:flexbox:${rootProject.extra["flexBoxVersion"] as String}")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")

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
