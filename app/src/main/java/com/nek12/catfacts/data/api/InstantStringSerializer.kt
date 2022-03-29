package com.nek12.catfacts.data.api

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Instant

class InstantStringSerializer : KSerializer<Instant> {

    override fun deserialize(decoder: Decoder): Instant {
        return Instant.parse(decoder.decodeString())
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("InstantStringSerializer", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Instant) {
        return encoder.encodeString(value.toString())
    }
}
