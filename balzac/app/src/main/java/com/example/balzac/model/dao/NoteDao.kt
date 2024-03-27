package com.example.balzac.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.balzac.model.Note
import io.reactivex.Observable

@Dao
interface NoteDao {
    @get:Query("SELECT * FROM note_table")
    val all: Observable<List<Note>>

    @Insert(onConflict = REPLACE)
    fun insert(note: Note)

    @Query("DELETE FROM note_table WHERE id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM note_table")
    fun deleteAll()

    @Update
    fun update(note: Note)

}