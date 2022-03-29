object Configuration {
    object App {

        val implementation = with(Deps) {
            listOf(
                collectionKtx,
//                vectorDrawable,
                paging,
                coreKtx,
                activityKtx,
//                paletteKtx,
                lifecycleViewModelKtx,
                coil,
                logcat,
                room,
                roomKtx,
                collectionKtx,
                kotlinSerialization,
                Deps.AndroidUtils.room,
            ) + with(Deps.AndroidUtils) {
                listOf(
                    android,
                    coroutine,
                    compose,
                )
            } + Deps.Compose.all + Common.implementation + Deps.Koin.all + Deps.Retrofit.all
        }
        val debugImplementation = listOf(
            Deps.Compose.tooling,
            Deps.Compose.testManifest,
        )
    }

    object Common {

        val androidTest = with(Deps.AndroidTest) {
            listOf(
                runner,
                junit,
                espresso,
                composeTest
            )
        }

        val test = with(Deps.Test) {
            listOf(
                junit,
                koin,
                mockito,
                robolectric,
                paging,
                compose,
                Deps.Compose.testManifest,
            )
        }

        val implementation = with(Deps) {
            listOf(
                stdlib,
                Deps.AndroidUtils.core,
                datetime,
            )
        }
    }
}
