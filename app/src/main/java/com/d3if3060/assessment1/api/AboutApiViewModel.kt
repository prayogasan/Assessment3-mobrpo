package com.d3if3060.assessment1.api

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutApiViewModel : ViewModel() {
    private val aboutApi: AboutApi = AboutApi.create()
    val aboutData: MutableLiveData<AboutResponse> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    fun fetchAboutData() {
        aboutApi.getAbout().enqueue(object : Callback<AboutResponse> {
            override fun onResponse(call: Call<AboutResponse>, response: Response<AboutResponse>) {
                if (response.isSuccessful) {
                    val aboutResponse = response.body()
                    aboutData.value = aboutResponse
                    Log.d(TAG, "Data JSON berhasil diambil: $aboutResponse")
                } else {
                    errorMessage.value = "Failed to retrieve about data."
                    Log.e(TAG, "Gagal mengambil data JSON: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<AboutResponse>, t: Throwable) {
                errorMessage.value = "Network error occurred."
                Log.e(TAG, "Kesalahan jaringan: ${t.message}")
            }
        })
    }

}
