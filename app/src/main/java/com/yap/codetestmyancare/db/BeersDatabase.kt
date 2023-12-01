package com.yap.myancare.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yap.myancare.response.Beer

@Database(entities = [Beer::class], version = 1)
abstract class BeerDB : RoomDatabase() {

    abstract fun getBeerDAO(): BeerDao

}