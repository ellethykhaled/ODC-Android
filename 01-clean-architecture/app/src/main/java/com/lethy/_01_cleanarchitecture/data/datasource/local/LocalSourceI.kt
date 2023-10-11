package com.lethy._01_cleanarchitecture.data.datasource.local

import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

interface LocalSourceI {
    fun getPhoneData(): PhoneDataModel
}