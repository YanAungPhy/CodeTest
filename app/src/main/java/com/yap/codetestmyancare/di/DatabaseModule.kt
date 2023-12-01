package com.yap.myancare.di

import android.content.Context
import androidx.room.Room
import com.yap.myancare.db.BeerDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {


    @Singleton
    @Provides
    fun provideBeerDB(context: Context): BeerDB {
        return Room.databaseBuilder(context, BeerDB::class.java, "BeerDB").build()
    }
}