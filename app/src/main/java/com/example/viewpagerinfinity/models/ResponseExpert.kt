package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ResponseExpert (
    var info: Info,
    @SerializedName("first_expert") var firstExpert :Expert,
    var article: Article,
    @SerializedName("list_expert") var listExpert:List<Expert>
)