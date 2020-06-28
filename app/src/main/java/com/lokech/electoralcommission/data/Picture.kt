package com.lokech.electoralcommission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    val id: String = "",
    val title: String = "",
    val pictureUrl: String = "",
    val category: String = ""
) : Parcelable