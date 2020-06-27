package com.lokech.electoralcommission.util

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.lokech.electoralcommission.data.Info
import com.lokech.electoralcommission.data.Picture
import timber.log.Timber
import java.io.InputStream
import java.util.*


val db: FirebaseFirestore = Firebase.firestore

val storage: FirebaseStorage = Firebase.storage

val infoCollection = db.collection("info")

val galleryCollection: CollectionReference = db.collection("gallery")

val searchCollection: CollectionReference = db.collection("searches")

//fun saveJourney(journey: Journey) {
//    journeyCollection.document(journey.id)
//        .set(journey, SetOptions.merge())
//        .addOnSuccessListener { Timber.i("Saved journey: $journey") }
//}
//
//fun saveSearch(search: Search) {
//    searchCollection.document(search.searchWord)
//        .set(search, SetOptions.merge())
//        .addOnSuccessListener { Timber.i("Saved search: $search") }
//}


fun uploadPicture(
    stream: InputStream,
    onUpload: (pictureUrl: String) -> Unit
) {
    val name = Date().time.toString()
    val uploadRef: StorageReference = storage.reference.child("images").child(name)
    uploadRef
        .putStream(stream)
        .continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let { throw it }
            }
            uploadRef.downloadUrl
        }
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onUpload(task.result.toString())
            }
        }
}

fun uploadAudioFile(audioStream: InputStream, onUpload: (audioUrl: String) -> Unit) {
    val uploadRef = storage.reference.child("audios").child(Date().time.toString())
    uploadRef.putStream(audioStream)
        .continueWithTask { task ->
            if (!task.isSuccessful) {
                task.exception?.let { throw it }
            }
            uploadRef.downloadUrl
        }
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onUpload(task.result.toString())
                Timber.i("download url is ${task.result}")
            }
        }
}

fun withInfo(lambda: (info: Info) -> Unit) {
    infoCollection.document("ec_info").addSnapshotListener { snapshot, _ ->
        snapshot?.toObject<Info>()?.let { lambda(it) }
    }
}

fun withPictureList(lambda: (pictureList: List<Picture>) -> Unit) {
    galleryCollection.addSnapshotListener { snapshot, _ ->
        snapshot?.toObjects<Picture>()?.let { lambda(it) }
    }
}