package com.lethy._01_cleanarchitecture.data.network

import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("phone-type/")
    fun getPhoneType(): Call<PhoneDataModel>
}