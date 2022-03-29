plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin(Deps.Plugins.serialization) version Versions.kotlin
    id(Deps.Plugins.ksp) version "${Versions.kotlin}-${Versions.ksp}"
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Config.testRunner
    }

    applicationVariants.all {
        outputs.all {
            if (name.contains("release")) {
                (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                    "../../apk/$applicationId-$name-$versionName.apk"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = Config.isMinifyEnabledRelease
            isShrinkResources = Config.isMinifyEnabledRelease

            proguardFiles(
                getDefaultProguardFile(Config.defaultProguardFile),
                Config.proguardFiles,
            )
            ndk.debugSymbolLevel = Config.debugSymbolLevel
        }
        getByName("debug") {
            versionNameSuffix = "-d"
            isRenderscriptDebuggable = true
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = Versions.java
        targetCompatibility = Versions.java
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
        freeCompilerArgs = Config.kotlinCompilerArgs
    }

    buildFeatures {
        aidl = false
        buildConfig = true
        compose = true
        dataBinding = false
        prefab = false
        renderScript = false
        resValues = true
        shaders = true
        viewBinding = false
        mlModelBinding = false
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.compose
        useLiveLiterals = true
    }

    ksp {
        arg("room.schemaLocation", "dbschema/")
        arg("room.incremental", "true")
        arg("room.expandProjection", "true")
    }
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

dependencies {
    Configuration.App.implementation.forEach(::implementation)
    Configuration.App.debugImplementation.forEach(::debugImplementation)
    Configuration.Common.test.forEach(::testImplementation)
    Configuration.Common.androidTest.forEach(::androidTestImplementation)
    ksp(Deps.Ksp.destinations)
    ksp(Deps.Ksp.room)

}
