package com.lokech.electoralcommission.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lokech.electoralcommission.data.Picture
import com.lokech.electoralcommission.util.withPictureList

class GalleryViewModel : ViewModel() {
    val pictureListLiveData = MutableLiveData<List<Picture>>()

    init {
        setPictureList()
    }
}

fun GalleryViewModel.setPictureList() {
    withPictureList { pictureListLiveData.value = it }
}