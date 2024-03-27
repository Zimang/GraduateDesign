package com.example.balzac.model.database

import android.app.Application
import com.example.balzac.model.Note
import com.example.balzac.model.dao.NoteDao
import com.example.balzac.model.Package
import com.example.balzac.model.dao.PackageDao
import io.reactivex.Observable
import kotlin.concurrent.thread

open class LocalDataSource(application: Application) {
    private val noteDao: NoteDao
    private val packageDao: PackageDao
    open val allNotes:Observable<List<Note>>
    open val allPackage: Observable<List<Package>>

    init {
        val db= LocalDatabase.getInstance(application)
        noteDao=db.noteDao()
        packageDao=db.packageDao()
        allNotes=noteDao.all
        allPackage=packageDao.all
    }

    //note
    fun insertNote(note: Note) {
        thread {
            noteDao.insert(note)
        }
    }
    fun deleteNote(note: Note) {
        thread {
            noteDao.delete(note.id)
        }
    }
    fun updateNote(note: Note) {
        thread {
            noteDao.update(note)
        }
    }
    //package
    fun insertPackage(note_package: Package) {
        thread {
            packageDao.insert(note_package)
        }
    }
    fun deletePackage(note_package: Package){
        thread {
            packageDao.delete(note_package.id)
        }
    }
    fun updatePackage(note_package: Package) {
        thread {
            packageDao.update(note_package)
        }
    }



}