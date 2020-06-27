package com.lokech.electoralcommission.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import com.lokech.electoralcommission.data.Info
import com.lokech.electoralcommission.util.infoCollection

class InfoViewModel : ViewModel() {

    val infoLiveData = MutableLiveData<Info>()

    init {
        setInfoLiveData()
    }


}

fun InfoViewModel.setInfoLiveData() {
    infoCollection.document("ec_info").addSnapshotListener { snapshot, _ ->
        infoLiveData.value = snapshot?.toObject<Info>()
    }
}
