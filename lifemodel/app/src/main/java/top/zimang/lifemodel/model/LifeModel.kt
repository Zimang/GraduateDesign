package top.zimang.lifemodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import top.zimang.lifemodel.utils.WithGson

@Entity(tableName = "life_model_table")
data class LifeModel (
    @SerializedName("life_model_id")
    @ColumnInfo(name = "life_model_id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    var lifeModelId:Int?,
    @SerializedName("life_model_name")
    @ColumnInfo(name = "life_model_name")
    @Expose
    var lifeModelName:String?,
    @SerializedName("living_portion")
    @ColumnInfo(name = "living_portion")
    @Expose
    var livingPortion: Int?=null,
    @SerializedName("investment_portion")
    @ColumnInfo(name = "investment_portion")
    @Expose
    var investmentPortion: Int?=null,
    @SerializedName("saving_portion")
    @ColumnInfo(name = "saving_portion")
    @Expose
    var savingPortion: Int?=null,
    @SerializedName("social_relationship_portion")
    @ColumnInfo(name = "social_relationship_portion")
    @Expose
    var socialRelationshipPortion: Int?=null
){
    override fun toString(): String {
        return "生活模型:${lifeModelName?: "默认生活模型"}${lifeModelId} => 生活:${livingPortion?: 0}%,投资:${investmentPortion?: 0}%,存储:${savingPortion?: 0}%,人际关系:${socialRelationshipPortion?: 0}%"
    }
    fun toJson():String{
        return WithGson.toJson(this)
    }
}