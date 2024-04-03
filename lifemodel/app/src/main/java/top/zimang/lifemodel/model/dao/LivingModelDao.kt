package top.zimang.lifemodel.model.dao

import androidx.room.*
import top.zimang.lifemodel.model.LivingModel

@Dao
interface LivingModelDao {
    @get:Query("SELECT * FROM living_model_table")
    val all: List<LivingModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(livingModel: LivingModel)

    @Query("DELETE FROM living_model_table WHERE living_model_id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM living_model_table")
    fun deleteAll()

    @Update
    fun update(livingModel: LivingModel)
}