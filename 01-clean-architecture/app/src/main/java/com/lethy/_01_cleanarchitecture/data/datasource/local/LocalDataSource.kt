package com.lethy._01_cleanarchitecture.data.datasource.local

import android.util.Log
import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

class LocalDataSource : LocalSourceI {

    private var dummyToggler = false

    override fun getPhoneData(): PhoneDataModel {
        Log.i("Used source", "Local Data source")
        dummyToggler = !dummyToggler
        return PhoneDataModel(
            if (dummyToggler)
                "S"
            else
                "I"
        )
    }
}