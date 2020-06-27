package com.lokech.electoralcommission.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.data.Info
import com.lokech.electoralcommission.util.withInfo

class InfoViewModel : ViewModel() {

    val infoLiveData = MutableLiveData<Info>()

    init {
        setInfoLiveData()
    }

}

fun InfoViewModel.setInfoLiveData() {
    withInfo {
        infoLiveData.value = it
    }
}
