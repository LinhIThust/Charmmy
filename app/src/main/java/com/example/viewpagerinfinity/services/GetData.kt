package com.example.viewpagerinfinity.services

import android.util.Log.d
import android.widget.Adapter
import com.example.viewpagerinfinity.models.ResponseTabHome
import retrofit2.Callback
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import retrofit2.Call
import retrofit2.Response
import com.example.viewpagerinfinity.Utils
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.models.ResponseCategogy
import com.example.viewpagerinfinity.views.adapters.ArticleAdapter
import com.example.viewpagerinfinity.views.adapters.TabHomeAdapter

class GetData() {
    companion object {
        fun getDataTabHome(adapter: TabHomeAdapter) {
            api.getTabHome().enqueue(object : Callback<ResponseTabHome> {
                override fun onFailure(call: Call<ResponseTabHome>, t: Throwable) {
                }

                override fun onResponse(call: Call<ResponseTabHome>, response: Response<ResponseTabHome>) {
                    val responseTabHome = response.body()
                    d("home", responseTabHome!!.listRanking.toString())
                    d("home", responseTabHome!!.listCategory.toString())
                    d("home", responseTabHome!!.listExpert.toString())
                    d("home", responseTabHome!!.listTag.toString())
                    Utils.listRanking.addAll(responseTabHome!!.listRanking)
                    Utils.listExpert.addAll(responseTabHome!!.listExpert)
                    Utils.listTag.addAll(responseTabHome!!.listTag)
                    Utils.listCategory.addAll(responseTabHome!!.listCategory)
                    adapter.notifyDataSetChanged()
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
}