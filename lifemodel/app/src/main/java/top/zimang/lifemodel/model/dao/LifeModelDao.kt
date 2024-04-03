package top.zimang.lifemodel.model.dao

import androidx.room.*
import top.zimang.lifemodel.model.LifeModel

@Dao
interface LifeModelDao {
    @get:Query("SELECT * FROM life_model_table")
    val all: List<LifeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(lifeModel: LifeModel)

    @Query("DELETE FROM life_model_table WHERE life_model_id = :id")
    fun delete(id: Int?)

    @Query("DELETE FROM life_model_table")
    fun deleteAll()

    @Update
    fun update(lifeModel: LifeModel)
}