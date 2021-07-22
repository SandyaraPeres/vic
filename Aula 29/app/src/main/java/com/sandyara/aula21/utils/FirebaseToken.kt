package com.sandyara.aula21.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.sandyara.aula21.R
import com.sandyara.aula21.presentation.MainActivity

class FirebaseToken : FirebaseMessagingService(){
    override fun onNewToken(token: String) {
        Log.d("TokenFirebase", "Refreshed token: $token")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(p0: RemoteMessage) {
        //super.onMessageReceived(p0)

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val notificationManager = baseContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val notificationChannel = NotificationChannel("com.sandyara.aula21", "App marvel", NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(notificationChannel)

        val notification = NotificationCompat.Builder(this, "com.sandyara.aula21")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_account_circle_24))
            .setContentTitle("Titulo:" + p0.notification?.title)
            .setContentText(p0.notification?.body)
            .addAction(R.drawable.ic_baseline_search_24, "VISUALIZAR", pendingIntent)
            .setChannelId("com.sandyara.aula21")
            .build()

        //NotificationManagerCompat.from(this).notify(0, notification.build())

        notificationManager.notify(0, notification)
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
    }
}