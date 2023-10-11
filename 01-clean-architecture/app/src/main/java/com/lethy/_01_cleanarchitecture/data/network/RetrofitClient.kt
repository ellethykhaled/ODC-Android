package com.lethy._01_cleanarchitecture.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {

        private const val BASE_URL = "http://10.0.2.2:9999/"

        var retrofit: Retrofit? = null

        fun buildClient(): Retrofit {
            if (retrofit == null) {
                val dataClient = OkHttpClient().newBuilder()
                    .callTimeout(500, TimeUnit.MILLISECONDS)
                    .connectTimeout(500, TimeUnit.MILLISECONDS)
                    .readTimeout(500, TimeUnit.MILLISECONDS)
                    .writeTimeout(500, TimeUnit.MILLISECONDS)
                    .build()

                retrofit = Retrofit.Builder()
                    .client(dataClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}
