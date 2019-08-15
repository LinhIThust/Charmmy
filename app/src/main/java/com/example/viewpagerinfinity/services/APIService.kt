package com.example.viewpagerinfinity.services

import com.example.viewpagerinfinity.models.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("screen/top/below")
    fun getTabHome(): Call<ResponseTabHome>

    @GET("header")
    fun getAllHeader(): Call<ListTabHeader>

    @GET("screen/category/{id}?")
    fun getCatelogy(
        @Path("id") id: Int,
        @Query("c") number: Int
    ): Call<ResponseCategogy>

    @GET("screen/pickup?")
    fun getPickup(
        @Query("c") number: Int
    ): Call<ResponsePickUp>

    @GET("screen/expert-list?")
    fun getExpert(
        @Query("p") id: Int
    ): Call<ResponseExpert>

    @GET("screen/search-result?")
    fun getSearchResult(
        @Query("keyword") key:String,
        @Query("s") type:String,
        @Query("p") page:Int
    ):Call<ResponseSearch>

    @GET("screen/article/{id}")
    fun getContentAritcle(
        @Path("id" )id :Int
    ):Call<ResponseContentArticle>
}
