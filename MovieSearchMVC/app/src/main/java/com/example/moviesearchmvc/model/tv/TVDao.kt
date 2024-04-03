package com.example.moviesearchmvc.model.tv

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.moviesearchmvc.model.movie.Movie
import io.reactivex.Observable

@Dao
interface TVDao {
    @get:Query("SELECT * FROM tv_table")
    val all: Observable<List<TV>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tv: TV)

    @Query("DELETE FROM tv_table WHERE id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM tv_table")
    fun deleteAll()

    @Update
    fun update(tv: TV)
}