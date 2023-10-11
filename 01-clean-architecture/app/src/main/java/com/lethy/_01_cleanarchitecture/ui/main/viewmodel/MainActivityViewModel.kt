package com.lethy._01_cleanarchitecture.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lethy._01_cleanarchitecture.data.repository.RepositoryImpl
import com.lethy._01_cleanarchitecture.domain.usecase.PhoneUseCase
import com.lethy._01_cleanarchitecture.ui.main.model.MainModel
import com.lethy._01_cleanarchitecture.ui.main.model.toMainModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val phoneUseCase = PhoneUseCase(RepositoryImpl.provideRepositoryImpl())

    val mainModel = MutableLiveData<MainModel>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        getPhoneData()
    }

    fun getPhoneData() {
        CoroutineScope(Dispatchers.IO).launch {
            isLoading.postValue(true)
            mainModel.postValue(phoneUseCase.getPhone().toMainModel())
            isLoading.postValue(false)
        }
    }
}