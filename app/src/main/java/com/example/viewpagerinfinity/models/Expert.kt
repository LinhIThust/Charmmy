package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class Expert (
    var id :Int,
    var name :String,
    var icon : String,
    var description : String,
    var topic : String,
    var title:String,
    var likes :Int,
    var status :Int,
    @SerializedName("is_like") var isLike :Boolean
)