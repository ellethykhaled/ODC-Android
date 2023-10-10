package com.lethy._01_cleanarchitecture.data.datasource.remote

import android.util.Log
import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel
import com.lethy._01_cleanarchitecture.data.network.ApiService
import com.lethy._01_cleanarchitecture.data.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource : RemoteSourceI {

    private val apiService =
        RetrofitClient.buildClient().create(ApiService::class.java)


    override suspend fun getPhoneData() : PhoneDataModel {
        Log.i("Used source", "Remote Data source")
        val call = apiService.getPhoneType()

        var remoteData = PhoneDataModel()
        call.enqueue(object :Callback<PhoneDataModel>{
            override fun onResponse(
                call: Call<PhoneDataModel>,
                response: Response<PhoneDataModel>
            ) {
                Log.e("Call response", "Success")
                if (response.isSuccessful)
                    remoteData = response.body()!!
            }

            override fun onFailure(call: Call<PhoneDataModel>, t: Throwable) {
                Log.e("Call response", "Failed")
            }
        })

        return remoteData
    }
}