package com.nek12.catfacts.ui.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nek12.androidutils.extensions.core.toZDT
import com.nek12.androidutils.extensions.coroutines.toState
import com.nek12.catfacts.data.db.entity.CatEntity
import com.nek12.catfacts.data.repo.CatRepo
import com.nek12.catfacts.ui.screens.history.HistoryState.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

sealed class HistoryState {
    data class DisplayingHistory(
        val items: List<CatFactItem>,
    ) : HistoryState()

    object Loading : HistoryState()
    object Error : HistoryState()
}

class HistoryViewModel(
    private val repo: CatRepo,
) : ViewModel() {

    val state: StateFlow<HistoryState> = repo
        .getHistory() //will reload each time new entry is saved to the database
        .map(::mapToState)
        .catch { Error }
        .toState(viewModelScope, Loading)


    private fun mapToState(items: List<CatEntity>): HistoryState =
        DisplayingHistory(
            items.map { CatFactItem(it.id, it.fact, it.created.toZDT()) }
        )
}
