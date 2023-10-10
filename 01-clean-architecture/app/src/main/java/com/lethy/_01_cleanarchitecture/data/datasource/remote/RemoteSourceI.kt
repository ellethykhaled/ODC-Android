package com.lethy._01_cleanarchitecture.data.datasource.remote

import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

interface RemoteSourceI {
    suspend fun getPhoneData(): PhoneDataModel
}