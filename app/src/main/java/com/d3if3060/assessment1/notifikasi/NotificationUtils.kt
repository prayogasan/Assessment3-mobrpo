package com.d3if3060.assessment1.notifikasi

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.d3if3060.assessment1.R

object NotificationUtils {
    private const val CHANNEL_ID = "welcome_channel"
    private const val CHANNEL_NAME = "Welcome Channel"
    private const val NOTIFICATION_ID = 1

    fun showWelcomeNotification(context: Context) {
        // Buat NotificationManager
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Cek versi Android
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Buat NotificationChannel untuk Android Oreo ke atas
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        // Buat builder notifikasi
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle("Selamat Datang!")
            .setContentText("Terima kasih telah menggunakan aplikasi ini.")
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setAutoCancel(true)

        // Tampilkan notifikasi
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }
}
