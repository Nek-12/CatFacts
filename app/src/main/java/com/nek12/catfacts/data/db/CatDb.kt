package com.nek12.catfacts.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nek12.androidutils.room.RoomConverters
import com.nek12.catfacts.data.db.dao.CatDao
import com.nek12.catfacts.data.db.entity.CatEntity

@Database(
    entities = [CatEntity::class],
    version = 1,
)
@TypeConverters(RoomConverters::class)
abstract class CatDatabase : RoomDatabase() {

    abstract fun catDao(): CatDao

    companion object {

        val DATABASE_NAME = "cats.db"
    }
}
