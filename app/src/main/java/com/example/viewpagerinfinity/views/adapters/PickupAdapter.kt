package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.views.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pick_up.view.*

class PickupAdapter(val listArticle: List<Article>, val context: Context) :
    RecyclerView.Adapter<PickupAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.pick_up, p0, false))

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.ivPickUp.layoutParams.width = MainActivity.widthDevice /4
        p0.ivPickUp.layoutParams.height =  3*MainActivity.widthDevice /16
        p0.tvDesPickUp.text = listArticle[p1].title
        p0.tvCatePickUp.text=listArticle[p1].category.title
        Picasso.with(context).load(getURL(listArticle[p1].thumbnail)).into(p0.ivPickUp)
    }

    private fun getURL(thumbnail: String): String {
        val lisUrl = thumbnail.split("\"")
        return lisUrl[lisUrl.size - 4]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPickUp = itemView.ivPickUp
        val tvDesPickUp = itemView.tvPickUp
        val tvCatePickUp = itemView.tvCatePickUp
    }
}