import java.net.URI

plugins {
    `kotlin-dsl`
}

buildscript {
    repositories {
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Deps.Build.gradle)
        classpath(Deps.Build.kotlinPlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            url = URI("https://jitpack.io")
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> { kotlinOptions.jvmTarget = Versions.jvmTarget }

}
