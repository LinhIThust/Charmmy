package com.example.viewpagerinfinity.services

import android.util.Log.d
import com.example.viewpagerinfinity.Utils
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.models.ResponseCategogy
import com.example.viewpagerinfinity.models.ResponseTabHome
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import com.example.viewpagerinfinity.views.adapters.TabHomeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetData {
    fun getDataTabHome(adapter: TabHomeAdapter) {
        api.getTabHome().enqueue(object : Callback<ResponseTabHome> {
            override fun onFailure(call: Call<ResponseTabHome>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseTabHome>, response: Response<ResponseTabHome>) {
                val responseTabHome = response.body()
                d("tabHome", responseTabHome.toString());
                if (responseTabHome != null) {
                    Utils.listRanking.addAll(responseTabHome.listRanking)
                    Utils.listExpert.addAll(responseTabHome.listExpert)
                    Utils.listTag.addAll(responseTabHome.listTag)
                    adapter.notifyDataSetChanged()
                }

            }
        })
    }

    fun getDataTabCategory(id: Int, number: Int) {
        api.getCatelogy(id, number).enqueue(object : Callback<ResponseCategogy> {
            override fun onFailure(call: Call<ResponseCategogy>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseCategogy>, response: Response<ResponseCategogy>) {
                Utils.listArticle = emptyArray<Article>().toMutableList()
                Utils.listArticle.add(response.body()!!.article)
                Utils.listArticle.addAll(response.body()!!.listArticle)
            }
        })
    }
}
