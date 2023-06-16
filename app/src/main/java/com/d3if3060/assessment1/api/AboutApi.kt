package com.d3if3060.assessment1.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AboutApi {
    @GET("/posts") // Ganti dengan endpoint yang sesuai setelah baseUrl
    fun getAbout(): Call<AboutResponse>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/" // Ganti dengan URL API yang sesuai

        fun create(): AboutApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(AboutApi::class.java)
        }
    }
}

data class AboutResponse(val id: Int, val title: String, val body: String)
