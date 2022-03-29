package com.nek12.catfacts.ui.screens.cat_fact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nek12.androidutils.extensions.core.fold
import com.nek12.androidutils.extensions.core.toZDT
import com.nek12.androidutils.extensions.coroutines.launch
import com.nek12.androidutils.extensions.coroutines.toState
import com.nek12.catfacts.data.repo.CatRepo
import com.nek12.catfacts.ui.screens.cat_fact.CatFactState.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onSubscription
import logcat.logcat


class CatFactViewModel(
    private val repo: CatRepo,
) : ViewModel() {

    private val _state = MutableSharedFlow<CatFactState>()
    val state = _state
        .onSubscription { loadNext() }
        .toState(viewModelScope, Loading)


    fun loadNext() = launch {
        _state.emit(Loading)

        delay(1000L) //delay for demonstration purposes

        val state = repo.randomFact().fold(
            //Since every new GET request returns a different image, then different facts will result in reloading of the image
            onSuccess = { DisplayingFact("https://cataas.com/cat", it.fact, it.created.toZDT()) },
            onError = {
                logcat { it.asLog() }
                Error
            }
        )
        _state.emit(state)
    }
}
