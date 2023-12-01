package com.yap.myancare.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yap.myancare.MyApplication
import com.yap.myancare.adapter.BeerAdapter
import com.yap.myancare.databinding.ActivityMainBinding
import com.yap.myancare.viewModel.MainActivityViewModel
import com.yap.myancare.viewModel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BeerAdapter
    private lateinit var viewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory // Dagger will provide the object to this variable through field injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MyApplication).applicationComponent.inject(this)

        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainActivityViewModel::class.java]


        viewModel.beerLocalData.observe(this) { response ->
            Log.d("CheckResponse", "{$response}")
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            adapter = BeerAdapter(response, this)
            binding.recyclerView.adapter = adapter
        }


    }
}