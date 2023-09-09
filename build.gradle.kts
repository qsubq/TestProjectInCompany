plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

// Объявление переменных в файле проекта для более удобной модуляризации в будущем
val retrofitVersion by extra("2.9.0")
val navigationVersion by extra("2.6.0")
val daggerVersion by extra("2.43.2")
val flexBoxVersion by extra("3.0.0")
val picassoVersion by extra("2.71828")
val dotsIndicatorVersion by extra("5.0")
val glideVersion by extra("4.12.0")
