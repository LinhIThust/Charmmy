package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("rank") val rank:Int,
    @SerializedName("id") val id: Int,
    @SerializedName("likes")  val likes: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("category") val category: Category,
    @SerializedName("amount") val amount : Int,
    @SerializedName("content") val content: String,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("is_pr") val isPr: Boolean,
    @SerializedName("pusblish_time") val publishTime: String
)
