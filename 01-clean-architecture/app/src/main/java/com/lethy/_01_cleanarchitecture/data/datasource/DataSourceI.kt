package com.lethy._01_cleanarchitecture.data.datasource

import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

interface DataSourceI {
    suspend fun getPhoneData(): PhoneDataModel
}