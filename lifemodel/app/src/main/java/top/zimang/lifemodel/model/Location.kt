package top.zimang.lifemodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location_table")
data class Location(
    @ColumnInfo(name = "location_name")
    @SerializedName("location_name")
    @PrimaryKey
    @Expose
    var locationName:String,
    @ColumnInfo(name = "is_city")
    @SerializedName("is_city")
    @Expose
    var isCity:Boolean?,
    //url suffix
    //https://www.numbeo.com/cost-of-living/country_result.jsp?country=Afghanistan
    @ColumnInfo(name = "url")
    @SerializedName("url")
    @Expose
    var url:String?,
    @ColumnInfo(name = "location_list")
    @SerializedName("location_list")
    @Expose
    var locationList:List<Location>?
) {
}
