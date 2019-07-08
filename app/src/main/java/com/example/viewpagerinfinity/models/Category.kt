package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Category (
    var id :Int,
    var title:String,
    @SerializedName("list_article") var listArticle: List<Article>
)