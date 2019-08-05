package com.example.viewpagerinfinity

import android.content.Context
import android.content.Intent
import com.example.viewpagerinfinity.models.*
import com.example.viewpagerinfinity.views.ArticleActivity

class Utils {
    companion object {
        val listRanking = mutableListOf<Ranking>()
        var listExpert = mutableListOf<Expert>()
        val listCategory = mutableListOf<Category>()
        val listTag = mutableListOf<Tag>()
        val listHeader = mutableListOf<TabHeader>()
        var listArticle = mutableListOf<Article>()
        val vpMain = R.id.vpDemo
        fun getURL(thumbnail: String): String {
            val lisUrl = thumbnail.split("\"")
            return lisUrl[lisUrl.size - 4]
        }
        fun loadContentArticle(context:Context,id :Int){
            val intent = Intent(context,ArticleActivity::class.java)
            intent.putExtra("id",id)
            context.startActivity(intent)
        }
    }


}