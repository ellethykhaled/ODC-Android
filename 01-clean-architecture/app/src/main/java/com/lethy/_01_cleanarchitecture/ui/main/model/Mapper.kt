package com.lethy._01_cleanarchitecture.ui.main.model

import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel

fun PhoneDomainModel.toMainModel() = MainModel(this.phoneType)