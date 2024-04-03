package com.example.moviesearchmvc.model.movie

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null, //主键
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null, //海报 作图像
    @SerializedName("original_language")
    @Expose
    var originalLanguage: String? = null, //语言
    @SerializedName("original_name")
    @Expose
    var originalName: String? = null, //原名
    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null, //是否成人
    @SerializedName("overview")
    @Expose
    var overview: String? = null,  //简介
    @SerializedName("release_date")
    @Expose
    var releaseDate: String? = null, //发行时间
    @SerializedName("vote_average")
    @Expose
    var voteAverage: Float? = null,  //平均得分
    @SerializedName("vote_count")
    @Expose
    var voteCount: Int? = null,   //投票人数
    @SerializedName("title")
    @Expose
    var title: String? = null,  //名称
) {
    fun getReleaseYearFromDate(): String? {
        return  releaseDate?.split("-")?.get(0) ?: ""
//        return  releaseDate?.split("-")?.get(0)
    }
    @Ignore
    constructor() : this(null, null, null, null, null, null, null, null, null, null)
}
