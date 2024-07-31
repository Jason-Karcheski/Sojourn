package com.sojourn.common.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sojourn.common.data.database.dao.TripDao
import java.util.UUID

@Entity(tableName = TripDao.TABLE_NAME)
data class TripEntity(
    @PrimaryKey val uid: UUID = UUID.randomUUID(),
    val name: String
)
