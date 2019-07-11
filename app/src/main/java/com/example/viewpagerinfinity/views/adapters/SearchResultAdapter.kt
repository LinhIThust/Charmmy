package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.getURL
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.views.MainActivity.Companion.widthDevice
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search_layout.view.*

class SearchResultAdapter(val listArticle: List<Article>) :
    RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup, p1: Int
    ): ViewHolder = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_search_layout, p0, false))

    override fun getItemCount(): Int = listArticle.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.dataBing(listArticle[p1])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun dataBing(article: Article) {
            if (article.amount == 0) {
                itemView.tvTypeSearchResult.text = article.category.title
                itemView.tvTypeSearchResult.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)

            } else {
                itemView.tvTypeSearchResult.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.coin_s, 0, 0, 0)
                itemView.tvTypeSearchResult.text = article.amount.toString()
            }
            itemView.tvTitleSearchResult.text = article.title
            itemView.ivItemSearchResult.layoutParams.width = widthDevice / 3
            itemView.ivItemSearchResult.layoutParams.height = widthDevice / 4
            Picasso.with(itemView.context).load(getURL(article.thumbnail)).into(itemView.ivItemSearchResult)
        }

    }
}