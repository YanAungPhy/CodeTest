package com.yap.codetestmyancare

import android.content.Context
import androidx.lifecycle.ViewModel
import com.yap.myancare.di.DatabaseModule
import com.yap.myancare.di.NetworkModule
import com.yap.myancare.di.ViewModelModule
import com.yap.myancare.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class,ViewModelModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity) // for field inject property inside the MainActivity

    /** Dagger will check the MainActivity for the fields inside to provide values. Inorder to do that we need this inject method.
     * */

    fun getMap(): Map<Class<*>, ViewModel>
    // this is the map function that reruns any map data that in the Dagger reach

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}