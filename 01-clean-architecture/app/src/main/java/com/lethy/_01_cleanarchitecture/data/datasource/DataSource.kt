package com.lethy._01_cleanarchitecture.data.datasource

import android.util.Log
import android.widget.Toast
import com.lethy._01_cleanarchitecture.data.datasource.local.LocalDataSource
import com.lethy._01_cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

class DataSource : DataSourceI {

    private val localDataSource = LocalDataSource()
    private val remoteDataSource = RemoteDataSource()

    override suspend fun getPhoneData(): PhoneDataModel {
        return try {
            remoteDataSource.getPhoneData()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Error", "Failed to fetch remote data")
            localDataSource.getPhoneData()
        }
    }

    companion object {
        private var dataSource: DataSource? = null

        fun provideDataSource(): DataSource {
            if (dataSource != null)
                return dataSource!!
            dataSource = DataSource()
            return dataSource!!
        }
    }
}