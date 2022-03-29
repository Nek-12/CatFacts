package com.nek12.catfacts.ui.screens.history

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nek12.androidutils.compose.string
import com.nek12.catfacts.R
import com.nek12.catfacts.ui.rememberDateFormatter
import com.nek12.catfacts.ui.screens.history.HistoryState.*
import com.ramcosta.composedestinations.annotation.Destination
import org.koin.androidx.compose.viewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Destination
fun HistoryScreen() {
    val vm: HistoryViewModel by viewModel()
    val state by vm.state.collectAsState()
    val formatter = rememberDateFormatter()

    AnimatedContent(targetState = state) { state ->
        when (state) {
            is DisplayingHistory -> {
                LazyColumn(Modifier.fillMaxSize()) {
                    items(state.items, key = { it.key }) {
                        Card(
                            modifier = Modifier.padding(8.dp),
                            backgroundColor = MaterialTheme.colors.background,
                        ) {

                            Column(
                                Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = formatter.format(it.createdAt),
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                )

                                Spacer(Modifier.height(8.dp))

                                Text(
                                    text = it.text,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
            Error -> Text(R.string.common_unknown_error.string())
            Loading -> CircularProgressIndicator()
        }
    }
}
