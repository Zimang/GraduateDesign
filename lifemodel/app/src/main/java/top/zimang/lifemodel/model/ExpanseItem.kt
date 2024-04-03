package top.zimang.lifemodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "expanse_item_table")
data class ExpanseItem(
    @SerializedName("expanse_item_name")
    @ColumnInfo(name = "expanse_item_name")
    @Expose
    var expanseItemName:String?,
    @SerializedName("expanse_item_id")
    @ColumnInfo(name = "expanse_item_id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    var expanseItemId:Int?,
    @SerializedName("count")
    @ColumnInfo(name = "count")
    @Expose
    var count:Int?,
    @SerializedName("cost")
    @ColumnInfo(name = "cost")
    @Expose
    var cost:Double?,
    @SerializedName("currency_unit")
    @ColumnInfo(name = "currency_unit")
    @Expose
    var currencyUnit:String?,
    @SerializedName("currency_unit_name")
    @ColumnInfo(name = "currency_unit_name")
    @Expose
    var currencyUnitName:String?,
    @SerializedName("tag")
    @ColumnInfo(name = "tag")
    @Expose
    var tag: String?
) {
}