package com.lethy._01_cleanarchitecture.ui.main.model

import com.lethy._01_cleanarchitecture.R
import com.lethy._01_cleanarchitecture.domain.model.PhoneDomainModel

fun PhoneDomainModel.toMainModel() : MainModel {
    val resourceInt = when(this.phoneType) {
        PhoneType.Samsung.type -> R.string.samsung
        PhoneType.IPhone.type -> R.string.i_phone
        else -> R.string.unknown
    }
    return MainModel(resourceInt)
}

enum class PhoneType(val type: String) {
    Samsung("s"),
    IPhone("i")
}