package com.dbxprts.siepalumno.services

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber

class FCMMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(payload: RemoteMessage) {
        payload.data.let {
            Timber.d(it.toString())
        }

    }
}