package com.lethy._01_cleanarchitecture.domain.repository

import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel

interface PhoneRepository {
    suspend fun getPhoneData(): PhoneDomainModel
}