package com.lethy._01_cleanarchitecture.data.datasource.remote

import android.util.Log
import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel
import com.lethy._01_cleanarchitecture.data.network.ApiService
import com.lethy._01_cleanarchitecture.data.network.RetrofitClient

class RemoteDataSource : RemoteSourceI {

    private val apiService =
        RetrofitClient.buildClient().create(ApiService::class.java)


    override suspend fun getPhoneData(): PhoneDataModel {
        Log.i("Used source", "Remote Data source")

        val call = apiService.getPhoneType()

        val response = call.execute()
        if (response.isSuccessful)
            response.body()?.let { return it }

        throw RuntimeException()
    }
}