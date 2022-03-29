@file:UseSerializers(InstantStringSerializer::class)

package com.nek12.catfacts.data.api.model

import androidx.annotation.Keep
import com.nek12.catfacts.data.api.InstantStringSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Keep
@Serializable
data class GetCatFactResponse(
    val fact: String,
)
