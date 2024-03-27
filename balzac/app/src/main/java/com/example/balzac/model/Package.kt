package com.example.balzac.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "package_table")
data class Package(
    @SerializedName("package_name")
    @Expose
    var name:String?=null,
    @PrimaryKey
    @SerializedName("package_id")
    @Expose
    var id:Int?=null,
    @SerializedName("cover_id")
    @Expose
    var coverId:Int?=null,
    @SerializedName("sub_package_list")
    @Expose
    var subPackageList:List<Int>,
    @SerializedName("sub_note_list")
    @Expose
    var subNoteList:List<Int>
)
