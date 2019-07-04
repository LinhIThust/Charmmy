package com.example.viewpagerinfinity.services

import com.example.viewpagerinfinity.models.*
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

    @GET("screen/top/below?ids=")
    fun getScreenTag(): Call<ListTag>


    @GET("screen/category/1?lt=&li=0&fi=0&c=900")
    fun getArticle(): Call<ListArticle>
}