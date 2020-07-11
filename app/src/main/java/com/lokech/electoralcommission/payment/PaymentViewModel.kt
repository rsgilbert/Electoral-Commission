package com.lokech.electoralcommission.payment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PaymentViewModel : ViewModel() {

    val paymentLiveData = MutableLiveData<Payment>().apply { value = Payment() }


}


data class Payment(
    val position: String = "",
    val type: String = "",
    val network: String = "Airtel Money",
    val number: String = ""
)