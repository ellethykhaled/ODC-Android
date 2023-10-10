package com.lethy._01_cleanarchitecture.data

import com.lethy._01_cleanarchitecture.data.model.PhoneDataModel
import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel

fun PhoneDataModel.toDomainModel() = PhoneDomainModel(this.phoneType ?: "")