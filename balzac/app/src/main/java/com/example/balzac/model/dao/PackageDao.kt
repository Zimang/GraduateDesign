package com.example.balzac.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.balzac.model.Package
import io.reactivex.Observable

@Dao
interface PackageDao {
    @get:Query("SELECT * FROM package_table")
    val all:Observable<List<Package>>

    @Insert(onConflict = REPLACE)
    fun insert(note_package: Package)

    @Query("DELETE FROM package_table WHERE id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM package_table")
    fun deleteAll()

    @Update
    fun update(note_package: Package)

}