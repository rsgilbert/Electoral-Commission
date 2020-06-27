package com.lokech.electoralcommission.util

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


val Fragment.writeToStoragePermission: Int
    get() = ContextCompat.checkSelfPermission(
        requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

fun Context.openEmailApp(emailAddress: String) {
    val uri: Uri = Uri.fromParts("mailto", emailAddress, null)
    val intent = Intent(Intent.ACTION_SENDTO, uri)
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
    startActivity(intent)
}

fun Context.openBrowserApp(link: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(intent)
}

fun Context.openDialerApp(number: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$number")
    startActivity(intent)
}
