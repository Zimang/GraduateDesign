package com.example.moviesearchmvc.model.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesearchmvc.model.movie.Movie
import com.example.moviesearchmvc.model.movie.MovieDao
import com.example.moviesearchmvc.model.tv.TV
import com.example.moviesearchmvc.model.tv.TVDao

@Database(entities = [Movie::class,TV::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    //DAO
    abstract fun movieDao():MovieDao
    abstract fun tvDao():TVDao

    //companion
    companion object{
        private val lock=Any()

        private const val DB_NAME="the_movie_db"
        private var INSTANCE: LocalDatabase?=null

        fun getInstance(application: Application): LocalDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(application, LocalDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}