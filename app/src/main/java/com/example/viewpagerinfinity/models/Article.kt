package com.example.viewpagerinfinity.models

import android.content.Context
import com.google.gson.annotations.SerializedName

data class Article(
    var rank:Int,
    var id: Int,
    var likes: Int,
    var thumbnail: String,
    var title: String,
    var category: Category,
    var amount : Int,
    var content: String,
    @SerializedName("is_new") var isNew: Boolean,
    @SerializedName("is_pr") var isPr: Boolean,
    @SerializedName("pusblish_time") var publishTime: String
)