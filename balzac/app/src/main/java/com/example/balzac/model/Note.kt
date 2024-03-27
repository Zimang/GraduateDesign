package com.example.balzac.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey
    @SerializedName("note_id")
    @Expose
    var id:Int?=null,
    @SerializedName("cover_id")
    @Expose
    var coverId:Int?=null,
    @SerializedName("type")
    @Expose
    var type:Int?=null,
    @SerializedName("save_package")
    @Expose
    var savePackage:String?=null,
    @SerializedName("save_path")
    @Expose
    var savePath:String?=null,
    @SerializedName("is_encrypted")
    @Expose
    var isCrypto:Boolean?=null,
    @SerializedName("encrypted_key")
    @Expose
    var encryptedKey:String?=null
)
