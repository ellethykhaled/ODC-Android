package com.lethy._01_cleanarchitecture.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lethy._01_cleanarchitecture.databinding.ActivityMainBinding
import com.lethy._01_cleanarchitecture.ui.main.model.MainModel
import com.lethy._01_cleanarchitecture.ui.main.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel = MainActivityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fetchDataButton.setOnClickListener {
            viewModel.getPhoneData()
        }

        viewModel.mainModel.observe(this) { onPhoneDataLoaded(it) }
        viewModel.isLoading.observe(this) { handleLoadingData(it) }
    }

    private fun onPhoneDataLoaded(isDataLoaded: MainModel) {
        binding.phoneType.text = getString(isDataLoaded.phoneType)
    }

    private fun handleLoadingData(isLoading: Boolean) {
        if (isLoading)
            with(binding) {
                phoneType.visibility = View.GONE
                fetchDataButton.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
        else
            with(binding) {
                phoneType.visibility = View.VISIBLE
                fetchDataButton.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
    }
}