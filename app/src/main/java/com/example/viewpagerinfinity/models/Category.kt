package com.example.viewpagerinfinity.models

data class Category (
    var id :Int,
    var title:String,
    var list_article: List<Article>
)