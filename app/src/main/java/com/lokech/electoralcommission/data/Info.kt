package com.lokech.electoralcommission.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Info(
    val vision: String = "",
    val mission: String = "",
    val goal: String = "",
    val website: String = "",
    val facebook: String = "",
    val twitter: String = "",
    val youtube: String = "",
    val address: String = "",
    val email: String = "",
    val fax: String = "",
    val tollfree: String = "",
    val telephone: String = ""
) : Parcelable