package com.nek12.catfacts.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RoomDatabase
import com.nek12.androidutils.room.RoomDao
import com.nek12.catfacts.data.db.entity.CatEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CatDao(db: RoomDatabase) : RoomDao<Long, CatEntity>(db, CatEntity.TABLE_NAME) {

    @Query("SELECT * FROM ${CatEntity.TABLE_NAME} ORDER BY created DESC")
    abstract fun getAllByCreatedDate(): Flow<List<CatEntity>>
}
