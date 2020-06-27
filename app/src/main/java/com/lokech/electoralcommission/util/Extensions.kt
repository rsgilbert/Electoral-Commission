package com.lokech.electoralcommission.util

import android.Manifest
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


val Fragment.writeToStoragePermission: Int
    get() = ContextCompat.checkSelfPermission(
        requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

