package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("list_article") val listArticle: List<Article>
)
