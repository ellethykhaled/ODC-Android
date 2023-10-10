package com.lethy._01_cleanarchitecture.data.datasource

import com.lethy._01_cleanarchitecture.data.datasource.local.LocalDataSource
import com.lethy._01_cleanarchitecture.data.datasource.remote.RemoteDataSource
import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel

class DataSource : DataSourceI {

    private val localDataSource = LocalDataSource()
    private val remoteDataSource = RemoteDataSource()

    override suspend fun getPhoneData(): PhoneDataModel {
        val data = remoteDataSource.getPhoneData()
        return localDataSource.getPhoneData()
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