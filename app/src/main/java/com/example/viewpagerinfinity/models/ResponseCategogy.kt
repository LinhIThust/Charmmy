package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ResponseCategogy(
    @SerializedName("category") var category: Category,
    @SerializedName("banner") var article: Article,
    @SerializedName("info") var info: Info,
    @SerializedName("list_article") var listArticle: List<Article>
)

