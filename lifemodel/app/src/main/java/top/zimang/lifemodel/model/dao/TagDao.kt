package top.zimang.lifemodel.model.dao

import androidx.room.*
import top.zimang.lifemodel.model.Tag

@Dao
interface TagDao {
    @get:Query("SELECT * FROM tag_table")
    val all: List<Tag>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tag: Tag)

    @Query("DELETE FROM tag_table WHERE tag_id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM tag_table")
    fun deleteAll()

    @Update
    fun update(tag: Tag)
}