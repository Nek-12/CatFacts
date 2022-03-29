package com.nek12.catfacts.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun rememberDateFormatter(): DateTimeFormatter = remember { DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL) }
