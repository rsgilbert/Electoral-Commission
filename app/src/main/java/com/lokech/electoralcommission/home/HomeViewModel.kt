package com.lokech.electoralcommission.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.util.withPictureList

class HomeViewModel : ViewModel() {
    val pictureListLiveData = MutableLiveData<List<String>>()

    init {
        setPictureListLiveData()
    }
}

fun HomeViewModel.setPictureListLiveData() {
    withPictureList {
        pictureListLiveData.value = it.map { picture ->
            picture.pictureUrl
        }
    }

}