package com.nek12.catfacts.ui.screens.history

import java.time.ZonedDateTime

data class CatFactItem(
    val key: Long,
    val text: String,
    val createdAt: ZonedDateTime,
)
