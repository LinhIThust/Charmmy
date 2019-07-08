package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ResponsePickUp(
    var info: Info,
    @SerializedName("list_article") var listArticle: List<Article>
)