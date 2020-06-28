package com.lokech.electoralcommission.parties

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.data.Party
import com.lokech.electoralcommission.util.withPartyList

class PartyListViewModel : ViewModel() {
    val partyListLiveData = MutableLiveData<List<Party>>()

    init {
        setPartyListLiveData()
    }
}

fun PartyListViewModel.setPartyListLiveData() {
    withPartyList { partyListLiveData.value = it }
}