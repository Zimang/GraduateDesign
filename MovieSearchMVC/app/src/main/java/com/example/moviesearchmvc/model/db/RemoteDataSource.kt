package com.example.moviesearchmvc.model.db

import com.example.moviesearchmvc.model.movie.MovieResponse
import com.example.moviesearchmvc.network.NetworkClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class RemoteDataSource {
    fun searchMovieResultsObservable(query: String): Observable<MovieResponse> {
        return NetworkClient.moviesApi
            .searchMovie(NetworkClient.API_KEY, query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}