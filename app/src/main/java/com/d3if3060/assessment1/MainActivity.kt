package com.d3if3060.assessment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.d3if3060.assessment1.notifikasi.NotificationUtils

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tampilkan notifikasi selamat datang
        NotificationUtils.showWelcomeNotification(this)

        // Jadwalkan pekerjaan UpdateWorker
        val updateWorkRequest = OneTimeWorkRequestBuilder<UpdateWorker>().build()
        WorkManager.getInstance(this).enqueue(updateWorkRequest)

        navController = findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
