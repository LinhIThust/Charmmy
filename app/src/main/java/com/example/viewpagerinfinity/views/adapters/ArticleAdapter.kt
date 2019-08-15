package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.getURL
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.views.MainActivity.Companion.widthDevice
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_layout.view.*

class ArticleAdapter(val listArticle: List<Article>, val context: Context) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    var onItemClick: (id: Int) -> Unit = {}

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.article_layout, p0, false),
        onItemClick
    )

    override fun getItemCount() = listArticle.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) = with(viewHolder) {

        ivArticle.layoutParams.width = if (position == 0) widthDevice - 50 else 5 * widthDevice / 11

        ivArticle.layoutParams.apply {
            width = ivArticle.layoutParams.width
            height = 2 * (ivArticle.layoutParams.width) / 3
        }

        tvArticle.text = listArticle[position].title

        Picasso.with(context).load(getURL(listArticle[position].thumbnail)).into(ivArticle)

        click(listArticle[position].id)
    }

    class ViewHolder(
        itemView: View,
        var onItemClick: (id: Int) -> Unit = {}
    ) : RecyclerView.ViewHolder(itemView) {

        var ivArticle = itemView.ivArticle
        var tvArticle = itemView.tvArticle

        fun click(id: Int) {
            itemView.ivArticle.setOnClickListener { onItemClick(id) }
        }
    }
}
