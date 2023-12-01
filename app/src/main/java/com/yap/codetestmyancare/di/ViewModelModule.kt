package com.yap.myancare.di


import androidx.lifecycle.ViewModel
import com.yap.myancare.viewModel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @ClassKey(MainActivityViewModel::class)
    @IntoMap
    abstract fun  mainViewModel(mainViewModel: MainActivityViewModel):ViewModel
    // what this fun do is , it will bind the mainViewModel object with the  ViewModel
    // when ever there is a request for a viewModel it will return mainViewModel object.

    /**
     * @ClassKey() and @Intomap. what these two annotation do ?
     *  it will create a map with key as class name and value as the object below @IntoMap. Here it is ViewModel.
     *
     * so it will be like MainViewModel::class -> MainViewModel
     * MainViewModel2::class -> MainViewModel2
     */


}