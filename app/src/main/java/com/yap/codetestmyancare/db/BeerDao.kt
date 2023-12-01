package com.yap.myancare.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yap.myancare.response.Beer

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(beers: List<Beer>)

    @Query("SELECT * FROM beers")
    fun getAllBeers(): LiveData<List<Beer>>


    /* @Query("DELETE FROM beers")
     suspend fun deleteAllBeers()*/
}