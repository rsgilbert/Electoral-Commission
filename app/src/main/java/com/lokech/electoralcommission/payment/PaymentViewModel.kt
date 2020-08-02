package com.lokech.electoralcommission.payment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PaymentViewModel : ViewModel() {

    val paymentLiveData = MutableLiveData(Payment())


    val networkLiveData = MutableLiveData(0)
}


data class Payment(
    val position: String = "",
    val type: String = "",
    val network: String = "Airtel Money",
    val number: String = ""
)