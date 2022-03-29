@file:Suppress("unused", "MemberVisibilityCanBePrivate")

object Deps {
    object Build {

        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Plugins {

        const val serialization = "plugin.serialization"
        const val versions = "com.github.ben-manes.versions"
        const val parcelize = "org.jetbrains.kotlin.plugin.parcelize"
        const val ksp = "com.google.devtools.ksp"
        const val detekt = "io.gitlab.arturbosch.detekt"
    }

    /* Basic Android */
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.datetime}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
    const val roomPaging = "androidx.room:room-paging:${Versions.room}"

    /* Ktx */
    const val collectionKtx = "androidx.collection:collection-ktx:${Versions.Ktx.collection}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.Ktx.core}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"
    const val paletteKtx = "androidx.palette:palette-ktx:${Versions.Ktx.palette}"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    /* Async */
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
//     const val workMultiprocess = "androidx.work:work-multiprocess:2.7.0"

    const val logcat = "com.squareup.logcat:logcat:${Versions.logcat}"
    const val kotlinSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val room = "androidx.room:room-runtime:${Versions.room}"

    object Compose {

        const val ui = "androidx.compose.ui:ui:${Versions.Compose.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.Compose.compose}"
        const val material = "androidx.compose.material:material:${Versions.Compose.compose}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.compose}"
        const val activity = "androidx.activity:activity-compose:${Versions.activity}"
        const val animation = "androidx.compose.animation:animation:${Versions.Compose.compose}"
        const val graphics = "androidx.compose.animation:animation-graphics:${Versions.Compose.compose}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
        const val icons = "androidx.compose.material:material-icons-core:${Versions.Compose.compose}"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:${Versions.Compose.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.Compose.material3}"
        const val nav = "androidx.navigation:navigation-compose:${Versions.Compose.navigation}"
        const val koin = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
        const val destinations =
            "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.destinations}"
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.coil}"

        //has different naming scheme
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.constraintLayout}"

        //debugImplementation
        const val testManifest = "androidx.compose.ui:ui-test-manifest:${Versions.Compose.compose}"

        val all = listOf(
            ui,
            foundation,
            material,
            activity,
            animation,
            graphics,
//                    material3,
            viewModel,
            koin,
            paging,
            nav,
            constraintLayout,
//            collapsingToolbar,
            coilCompose,
            destinations,
        )
    }

    /** Complementary **/

    object AndroidUtils {

        private const val group = "com.github.Nek-12.AndroidUtils"

        const val core = "$group:core-ktx:${Versions.utils}"
        const val material = "$group:material-ktx:${Versions.utils}"
        const val android = "$group:android-ktx:${Versions.utils}"
        const val coroutine = "$group:coroutine-ktx:${Versions.utils}"
        const val room = "$group:room:${Versions.utils}"
        const val preferences = "$group:preferences-ktx:${Versions.utils}"
        const val compose = "$group:compose-ktx:${Versions.utils}"
    }

    object AndroidTest {

        const val runner = "androidx.test:runner:${Versions.Test.runner}"
        const val junit = "androidx.test.ext:junit:${Versions.Test.androidJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
        const val composeTest = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.compose}"

    }

    object Test {

        const val junit = "junit:junit:${Versions.Test.junit}"
        const val compose = "androidx.compose.ui:ui-test-junit4:${Versions.Compose.compose}"
        const val koin = "io.insert-koin:koin-test:${Versions.koin}"
        const val mockito = "org.mockito:mockito-core:${Versions.Test.mockito}"
        const val robolectric = "org.robolectric:robolectric:${Versions.Test.robolectric}"
        const val paging = "androidx.paging:paging-common:${Versions.paging}"
    }

    object Koin {

        const val core = "io.insert-koin:koin-core:${Versions.koin}"
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val workmanager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"

        val all = listOf(
            core,
            android,
            workmanager,
        )
    }

    object Retrofit {

        const val core = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}"
        const val scalars = "com.squareup.retrofit2:converter-scalars:${Versions.Retrofit.retrofit}"
        const val jsonConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.Retrofit.serialization}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.interceptor}"

        val all = listOf(
            jsonConverter,
            loggingInterceptor,
            scalars,
            core,
        )
    }

    object Ksp {

        const val destinations = "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.destinations}"
        const val room = "androidx.room:room-compiler:${Versions.room}"
    }
}
