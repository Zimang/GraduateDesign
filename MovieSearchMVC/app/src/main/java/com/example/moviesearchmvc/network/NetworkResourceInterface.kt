package com.example.moviesearchmvc.network

import com.example.moviesearchmvc.model.movie.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkResourceInterface {
    @GET("search/movie")
    fun searchMovie(@Query("api_key") api_key: String, @Query("query") q: String, @Query("language") language: String="zh-CH"): Observable<MovieResponse>
}