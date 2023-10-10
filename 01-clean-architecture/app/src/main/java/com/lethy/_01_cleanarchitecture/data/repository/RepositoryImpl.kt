package com.lethy._01_cleanarchitecture.data.repository

import com.lethy._01_cleanarchitecture.data.datasource.DataSource
import com.lethy._01_cleanarchitecture.data.toDomainModel
import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel
import com.lethy._01_cleanarchitecture.domain.repository.PhoneRepository

class RepositoryImpl : PhoneRepository {

    private val dataSource = DataSource.provideDataSource()

    override suspend fun getPhoneData(): PhoneDomainModel {
        return dataSource.getPhoneData().toDomainModel()
    }

    companion object {
        private var repositoryImpl: RepositoryImpl? = null
        fun provideRepositoryImpl(): RepositoryImpl {
            if (repositoryImpl != null)
                return repositoryImpl!!
            repositoryImpl = RepositoryImpl()
            return repositoryImpl!!
        }
    }
}