@file:Suppress("MemberVisibilityCanBePrivate")

import org.gradle.api.JavaVersion

object Config {

    const val applicationId = "com.nek12.catfacts"
    val versionCode = 1

    const val majorRelease = 0
    const val minorRelease = 2
    const val patch = 0
    val versionName = "$majorRelease.$minorRelease.${patch} ($versionCode)"

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val isMinifyEnabledRelease = false
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardFiles = "proguard-rules.pro"
    const val consumerProguardFiles = "consumer-rules.pro"
    const val debugSymbolLevel = "SYMBOL_TABLE"
    val supportedLocales = listOf("en")
    val kotlinCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xjvm-default=all")
}

object Versions {

    val java = JavaVersion.VERSION_11
    const val jvmTarget = "11"
    const val compileSdk = 31
    const val targetSdk = compileSdk
    const val minSdk = 26
    const val buildTools = "32.0.0"
    const val gradle = "7.1.2"
    const val kotlin = "1.6.10"
    const val datetime = "0.3.2"
    const val ksp = "1.0.4"
    const val activity = "1.5.0-alpha03"
    const val serialization = "1.3.2"
    const val room = "2.5.0-alpha01"
    const val koin = "3.2.0-beta-1"
    const val paging = "3.1.0"
    const val utils = "0.6.3"
    const val coroutines = "1.6.0"
    const val material = "1.6.0-alpha01"
    const val logcat = "0.1"
    const val vectorDrawable = "1.1.0"
    const val coil = "2.0.0-rc01"
    const val coilTransformations = "1.1.2"
    const val lifecycle = "2.5.0-alpha03"

    object Ktx {

        const val collection = "1.2.0"
        const val core = "1.9.0-alpha01"
        const val palette = "1.0.0"
    }

    object Compose {

        const val accompanist = "0.24.3-alpha"
        const val compose = "1.2.0-alpha04"
        const val material3 = "1.0.0-alpha03"
        const val constraintLayout = "1.0.0"
        const val navigation = "2.5.0-alpha03"
        const val destinations = "1.3.3-beta"
    }

    object Retrofit {

        const val interceptor = "5.0.0-alpha.5"
        const val retrofit = "2.9.0"
        const val serialization = "0.8.0"
    }

    object Test {

        const val junit = "4.13.2"
        const val runner = "1.4.1"
        const val espresso = "3.5.0-alpha04"
        const val androidJunit = "1.1.4-alpha04"
        const val mockito = "4.4.0"
        const val robolectric = "4.7.3"
    }

    object Plugin {

        const val versions = "0.42.0"
    }
}
