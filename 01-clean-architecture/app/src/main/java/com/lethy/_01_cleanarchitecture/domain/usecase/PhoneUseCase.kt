package com.lethy._01_cleanarchitecture.domain.usecase

import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel
import com.lethy._01_cleanarchitecture.domain.repository.PhoneRepository

class PhoneUseCase(private val phoneRepository: PhoneRepository) {

    suspend fun getPhone(): PhoneDomainModel {
        return phoneRepository.getPhoneData()
    }

}