package com.example.balzac.model.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.balzac.model.Note
import com.example.balzac.model.dao.NoteDao
import com.example.balzac.model.Package
import com.example.balzac.model.dao.PackageDao

@Database(entities = [Note::class, Package::class], version = 1)
abstract class LocalDatabase :RoomDatabase(){
    //DAO
    abstract fun noteDao(): NoteDao
    abstract fun packageDao(): PackageDao

    companion object{
        private const val DB_NAME = "note_database"
        private val lock = Any()
        private var INSTANCE: LocalDatabase? = null

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