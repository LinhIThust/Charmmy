package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("last_time") var lastTime :String,
    @SerializedName("last_article_id") var lastArticalId:Int,
    @SerializedName("is_more") var isMore:Boolean
)