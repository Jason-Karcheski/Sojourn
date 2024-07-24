package com.sojourn.common.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sojourn.common.data.database.dao.TripDao
import com.sojourn.common.data.database.entity.TripEntity

@Database(
    version = 1,
    entities = [TripEntity::class]
)
abstract class SojournDatabase: RoomDatabase() {
    abstract fun tripDao() : TripDao
}