package com.example.moviesearchmvc.model.db

import android.app.Application
import com.example.moviesearchmvc.model.movie.Movie
import com.example.moviesearchmvc.model.movie.MovieDao
import com.example.moviesearchmvc.model.tv.TV
import com.example.moviesearchmvc.model.tv.TVDao
import io.reactivex.Observable
import kotlin.concurrent.thread

open class LocalDataSource(application: Application) {
    private val movieDao:MovieDao
    private val tvDao:TVDao
    open val allMovies: Observable<List<Movie>>
    open val allTVs:Observable<List<TV>>

    init {
        val db=LocalDatabase.getInstance(application)
        movieDao=db.movieDao()
        tvDao=db.tvDao()

        allMovies=movieDao.all
        allTVs=tvDao.all
    }

    fun insert(movie: Movie) {
        thread {
            movieDao.insert(movie)
        }
    }

    fun delete(movie: Movie) {
        thread {
            movieDao.delete(movie.id)
        }
    }

    fun update(movie: Movie) {
        thread {
            movieDao.update(movie)
        }
    }

    fun insert(tv: TV) {
        thread {
            tvDao.insert(tv)
        }
    }

    fun delete(tv: TV) {
        thread {
            tvDao.delete(tv.id)
        }
    }

    fun update(tv: TV) {
        thread {
            tvDao.update(tv)
        }
    }
}