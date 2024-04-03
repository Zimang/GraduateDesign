package top.zimang.lifemodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "living_model_table")
data class LivingModel(
    @SerializedName("living_model_id")
    @ColumnInfo(name = "living_model_id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    var livingModelId: Int?,
    @SerializedName("living_model_name")
    @ColumnInfo(name = "living_model_name")
    @Expose
    var livingModelName:String?,
    @SerializedName("life_model_id")
    @ColumnInfo(name = "life_model_id")
    @Expose
    var lifeModelId: Int?,
    @SerializedName("city_name")
    @ColumnInfo(name = "city_name")
    @Expose
    var cityName: String?,
    @SerializedName("city_name_chinese")
    @ColumnInfo(name = "city_name_chinese")
    @Expose
    var cityNameCH: String?,
    @SerializedName("expanse_item_list")
    @ColumnInfo(name = "expanse_item_list")
    @Expose
    var expanseItemList: List<ExpanseItem>?
) {
}