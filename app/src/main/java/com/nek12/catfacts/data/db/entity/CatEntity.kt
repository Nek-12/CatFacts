package com.nek12.catfacts.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nek12.androidutils.room.RoomEntity
import java.time.Instant

@Entity(tableName = CatEntity.TABLE_NAME)
data class CatEntity(
    val fact: String,
    val created: Instant = Instant.now(),

    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
) : RoomEntity<Long> {

    companion object {
        const val TABLE_NAME = "cat"
    }
}
