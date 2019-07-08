package com.example.viewpagerinfinity.models

import com.google.gson.annotations.SerializedName

data class ListTabHeader(
    @SerializedName("list_tab") var listTabHeader: List<TabHeader>
)