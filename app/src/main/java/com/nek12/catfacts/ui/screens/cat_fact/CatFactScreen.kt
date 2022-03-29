package com.nek12.catfacts.ui.screens.cat_fact

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nek12.androidutils.compose.string
import com.nek12.catfacts.R
import com.nek12.catfacts.ui.rememberDateFormatter
import com.nek12.catfacts.ui.screens.cat_fact.CatFactState.*
import com.nek12.catfacts.ui.screens.destinations.HistoryScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.viewModel
import java.time.ZonedDateTime

@Composable
@Destination(start = true)
fun CatFactScreen(
    navigator: DestinationsNavigator,
) {
    val vm: CatFactViewModel by viewModel()
    val state by vm.state.collectAsState()

    CatFactScreenContent(
        state = state,
        onRefresh = { vm.loadNext() },
        onHistory = { navigator.navigate(HistoryScreenDestination()) })

}

@OptIn(ExperimentalAnimationApi::class) //optional for quick demonstration, not actually needed here
@Composable
fun CatFactScreenContent(state: CatFactState, onRefresh: () -> Unit = {}, onHistory: () -> Unit = {}) {
    val formatter = rememberDateFormatter()



    AnimatedContent(targetState = state) { state ->

        Column(Modifier
            .fillMaxSize()
            .padding(8.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            when (state) {
                is DisplayingFact -> {

                    Card(Modifier
                        .fillMaxWidth()
                        .heightIn(100.dp, 400.dp),
                        backgroundColor = MaterialTheme.colors.background
                    ) {

                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(state.imageUrl)
                                //Workaround coil skipping image loading by using a disk cache key that does not equal to previous
                                .diskCacheKey(state.text)
                                .memoryCacheKey(state.text)
                                .build(),
                            contentDescription = R.string.cat_image.string(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Text(
                        textAlign = TextAlign.Center,
                        text = state.text
                    )

                    Spacer(Modifier.height(12.dp))
                    Text(R.string.pattern_updated_at.string(formatter.format(state.createdAt)))
                    Spacer(Modifier.height(12.dp))

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {
                        Button(
                            onClick = onRefresh,
                            content = { Text(R.string.common_another_fact.string()) }
                        )
                        Button(
                            onClick = onHistory,
                            content = { Text(R.string.show_history.string()) }
                        )
                    }
                }
                Error -> {
                    Text(R.string.common_unknown_error.string())
                }
                Loading -> {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
@Preview(name = "CatFactScreen", showSystemUi = true, showBackground = true)
private fun CatFactScreenPreview() {
    Column {
        CatFactScreenContent(
            DisplayingFact("https://cataas.com/cat", "text", ZonedDateTime.now()),
        )
        CatFactScreenContent(state = Loading)
        CatFactScreenContent(state = Error)
    }
}
