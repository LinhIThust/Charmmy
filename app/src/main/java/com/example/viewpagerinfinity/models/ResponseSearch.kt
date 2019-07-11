package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ResponseSearch(
    var info: InfoSearch,
    @SerializedName("list_data") var listResult:List<Article>,
    @SerializedName("favorite_keywords") var listTag :List<Tag>
)

data class InfoSearch(
    @SerializedName("is_more") var isMore:Boolean,
    @SerializedName("total_records") var totalRecords:Int
)