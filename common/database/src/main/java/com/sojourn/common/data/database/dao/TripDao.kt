package com.sojourn.common.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.sojourn.common.data.database.entity.TripEntity

@Dao
interface TripDao {

    companion object {
        const val TABLE_NAME = "trip"
    }

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAll() : List<TripEntity>

    @Upsert
    fun upsertTrip(tripEntity: TripEntity)

    @Delete
    fun deleteTrip(tripEntity: TripEntity)

}