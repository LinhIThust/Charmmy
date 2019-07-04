package com.example.viewpagerinfinity.models

data class Article (
    var id :Int,
    var likes:Int,
    var thumbnail : String,
    var title : String,
    var is_new : Boolean,
    var is_pr : Boolean,
    var publish_time :String
)