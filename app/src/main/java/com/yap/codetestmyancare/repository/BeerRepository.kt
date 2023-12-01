package com.yap.myancare.repository

/*
import com.yap.myancare.db.BeersDatabase
*/
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yap.myancare.api.ApiService
import com.yap.myancare.db.BeerDB
import com.yap.myancare.response.Beer
import javax.inject.Inject

class BeerRepository @Inject constructor(
    private val api: ApiService,
    private val beerDB: BeerDB
) {

    private val _beers = MutableLiveData<List<Beer>>()
    val beers: LiveData<List<Beer>>
        get() = _beers

    // suspend function to call the api
    suspend fun getBeers() {
        try {
            val result = api.getBeersList()
            if (result.isSuccessful) {
                result.body()?.let { body ->
                    beerDB.getBeerDAO().insertAll(body)
                    _beers.postValue(body)
                }
            } else {
                getAllBeersFromDb()
            }
        } catch (e: Exception) {
            getAllBeersFromDb()
        }

    }

      fun getAllBeersFromDb(): LiveData<List<Beer>> {
           return beerDB.getBeerDAO().getAllBeers()
       }

}
