package top.zimang.lifemodel.model

import androidx.room.Embedded
import androidx.room.Relation

/**
     * lifeModel <1-N> LivingModel
 * lifeModel:
 * pk :lifeModelId
 * LivingModel：
 * pk: livingModelId
 */
data class LivingLife (
    @Embedded var lifeModel: LifeModel?,
    @Relation(
        parentColumn = "life_model_id",
        entityColumn = "life_model_id"
    )
    var livingModelList: List<LivingModel>?
){
}