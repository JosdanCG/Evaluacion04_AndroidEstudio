package com.daniel.evaluacion04.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.sportmonks.com/v3/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getPlayerService():PlayerService= retrofit.create(PlayerService::class.java)
}