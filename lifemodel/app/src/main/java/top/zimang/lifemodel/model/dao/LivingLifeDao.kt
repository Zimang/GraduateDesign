package top.zimang.lifemodel.model.dao

import androidx.room.*
import top.zimang.lifemodel.model.LivingLife

@Dao
interface LivingLifeDao {
    @Transaction
    @Query("SELECT * FROM life_model_table")
    fun getLivingLifeList(): List<LivingLife>

}