package com.yap.myancare.api

import com.yap.myancare.response.Beer
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //https://api.punkapi.com/v2/beers
    @GET("beers")
    suspend fun getBeersList(): Response<List<Beer>>
}