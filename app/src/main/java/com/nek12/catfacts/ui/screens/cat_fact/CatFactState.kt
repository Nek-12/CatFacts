package com.nek12.catfacts.ui.screens.cat_fact

import java.time.ZonedDateTime

//view state derived from MVI. Not full MVI implementation because of small scale of the project
sealed class CatFactState {

    data class DisplayingFact(
        val imageUrl: String,
        val text: String,
        val createdAt: ZonedDateTime,
    ) : CatFactState()

    object Loading : CatFactState()
    object Error : CatFactState()
}
