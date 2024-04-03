package top.zimang.lifemodel.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tag_table")
data class Tag(
    @SerializedName("tag_name")
    @ColumnInfo(name = "tag_name")
    @Expose
    var tagName:String?,
    @SerializedName("tag_id")
    @ColumnInfo(name = "tag_id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    var tagId:Int?
) {
}