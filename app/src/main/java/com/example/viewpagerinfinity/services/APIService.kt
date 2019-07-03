package com.example.viewpagerinfinity.services

import com.example.viewpagerinfinity.models.ListCategory
import com.example.viewpagerinfinity.models.ListExpert
import com.example.viewpagerinfinity.models.ListRanking
import com.example.viewpagerinfinity.models.ListTabHeader
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("header")
    fun getAllHeader(): Call<ListTabHeader>

    @GET("screen/top/below")
    fun getScreenRanking(): Call<ListRanking>

    @GET("screen/top/below?ids=")
    fun getScreenExpert(): Call<ListExpert>

    @GET("screen/top/below?ids=")
    fun getScreenCategory(): Call<ListCategory>
}