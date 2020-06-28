package com.lokech.electoralcommission.parties

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.data.Party
import com.lokech.electoralcommission.util.withParty
import timber.log.Timber

class PartyViewModel(val partyId: String) : ViewModel() {

    val partyLiveData = MutableLiveData<Party>()

    init {
        setPartyLiveData()
    }
}

fun PartyViewModel.setPartyLiveData() {
    Timber.i("Party id is $partyId")
    withParty(partyId) {
        partyLiveData.value = it
        Timber.i("Party is $it")
    }
}

