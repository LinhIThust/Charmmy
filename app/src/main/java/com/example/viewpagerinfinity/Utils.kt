package com.example.viewpagerinfinity

import com.example.viewpagerinfinity.models.*

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
    }


}