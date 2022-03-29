package com.nek12.catfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nek12.catfacts.ui.screens.NavGraphs
import com.nek12.catfacts.ui.theme.CatFactsTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        actionBar?.hide()

        setContent {
            CatFactsTheme(darkTheme = false) {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
