package com.sojourn.common.data.database.di

import android.content.Context
import androidx.room.Room
import com.sojourn.common.data.database.SojournDatabase
import com.sojourn.common.data.database.dao.TripDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesSojournDatabase(@ApplicationContext context: Context) : SojournDatabase =
        Room.databaseBuilder(
            context = context,
            klass = SojournDatabase::class.java,
            name = "sojourn-database"
        ).build()

    @Provides
    fun providesTripDao(database: SojournDatabase) : TripDao = database.tripDao()

}