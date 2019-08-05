package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ResponseTabHome(
    @SerializedName("list_expert") var listExpert: List<Expert>,
    @SerializedName("list_ranking") var listRanking: List<Ranking>,
    @SerializedName("list_tag") var listTag: List<Tag>
)