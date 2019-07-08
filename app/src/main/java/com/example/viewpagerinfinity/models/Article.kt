package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Article(
    var rank:Int,
    var id: Int,
    var likes: Int,
    var thumbnail: String,
    var title: String,
    var category: Category,
    @SerializedName("is_new") var isNew: Boolean,
    @SerializedName("isPr") var isPr: Boolean,
    @SerializedName("pusblish_time") var publishTime: String
)