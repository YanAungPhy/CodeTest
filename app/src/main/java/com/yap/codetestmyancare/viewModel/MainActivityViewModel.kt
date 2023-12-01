package com.yap.myancare.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yap.myancare.db.BeerDao
import com.yap.myancare.repository.BeerRepository
import com.yap.myancare.response.Beer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private  val repository: BeerRepository
): ViewModel() {

    val beerLiveData:LiveData<List<Beer>>
        get() =repository.beers

    val beerLocalData:LiveData<List<Beer>>
        get()= repository.getAllBeersFromDb()

    init {
        viewModelScope.launch {
            repository.getBeers()
        }
    }
}