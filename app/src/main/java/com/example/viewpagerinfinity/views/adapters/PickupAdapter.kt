package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.getURL
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.views.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pick_up.view.*

class PickupAdapter(val listArticle: List<Article>) :
    RecyclerView.Adapter<PickupAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.pick_up, p0, false))

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.dataBinding(listArticle[p1])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun dataBinding(article: Article) {
            itemView.ivPickUp.layoutParams.width = MainActivity.widthDevice / 3
            itemView.ivPickUp.layoutParams.height =MainActivity.widthDevice / 4

            Picasso.with(itemView.context).load(getURL(article.thumbnail)).into(itemView.ivPickUp)
            itemView.tvPickUp.text = article.title
            itemView.tvCatePickUp.text = article.category.title
        }
    }
}