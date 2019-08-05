package com.example.viewpagerinfinity.models

data class Ranking (
    var id :String,
    var thumbnail :String,
    var category: Category,
    var title : String,
    var rank :Int
)