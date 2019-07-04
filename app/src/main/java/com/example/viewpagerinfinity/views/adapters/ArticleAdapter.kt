package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_layout.view.*

class ArticleAdapter(val listArticle : List<Article>,val context :Context):RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int
    ) = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.article_layout,p0,false))

    override fun getItemCount() = listArticle.size
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvArticle.text=listArticle[p1].title
        Picasso.with(context).load(getURL(listArticle[p1].thumbnail)).into(p0.ivArticle)
    }

    private fun getURL(thumbnail: String): String {
        val lisUrl = thumbnail.split("\"")
        return lisUrl[lisUrl.size -4]
    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val ivArticle = itemView.ivArticle
        val tvArticle =itemView.tvArticle
    }
}