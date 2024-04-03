package com.example.moviesearchmvc.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    const val API_KEY=""
    const val TMDB_BASE_URL = "http://api.themoviedb.org/3/"
    const val TMDB_IMAGEURL = "https://image.tmdb.org/t/p/w500/"

    val moviesApi = Retrofit.Builder()
        .baseUrl(TMDB_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(NetworkResourceInterface::class.java)
}