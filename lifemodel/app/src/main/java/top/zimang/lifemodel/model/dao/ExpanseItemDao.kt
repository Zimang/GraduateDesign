package top.zimang.lifemodel.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import top.zimang.lifemodel.model.ExpanseItem

@Dao
interface ExpanseItemDao {
    @get:Query("SELECT * FROM expanse_item_table")
    val all: List<ExpanseItem>

    @Insert(onConflict = REPLACE)
    fun insert(expanseItem: ExpanseItem)

    @Query("DELETE FROM expanse_item_table WHERE expanse_item_id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM expanse_item_table")
    fun deleteAll()

    @Update
    fun update(expanseItem: ExpanseItem)
}