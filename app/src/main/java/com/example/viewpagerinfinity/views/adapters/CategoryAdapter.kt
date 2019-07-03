package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Category
import com.squareup.picasso.Picasso

class CategoryAdapter(val listCategory: List<Category>,val context:Context
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int
    ) = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.categorys,p0,false))

    override fun getItemCount() = listCategory.size

    override fun onBindViewHolder(p0:ViewHolder, p1: Int) {
        p0.tvNameCategory.text = listCategory[p1].title
        p0.tvTitleCate1.text =listCategory[p1].list_article[0].title
        p0.tvTitleCate2.text =listCategory[p1].list_article[1].title
        Picasso.with(context).load(getURL(listCategory[p1].list_article[0].thumbnail)).into(p0.ivCategory1)
        Picasso.with(context).load(getURL(listCategory[p1].list_article[1].thumbnail)).into(p0.ivCategory2)
    }

    private fun getURL(thumbnail: String): String {
        val listUrl = thumbnail.split("\"")
        d("abcd",listUrl[listUrl.size -4])
        return listUrl[listUrl.size -4]
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val tvNameCategory = itemView.findViewById<TextView>(R.id.tvnameCategory)
        val tvTitleCate1 = itemView.findViewById<TextView>(R.id.tvTitleCate1)
        val tvTitleCate2 = itemView.findViewById<TextView>(R.id.tvTitleCate2)
        val ivCategory1 = itemView.findViewById<ImageView>(R.id.ivCategory1)
        val ivCategory2 = itemView.findViewById<ImageView>(R.id.ivCategory2)



    }

}