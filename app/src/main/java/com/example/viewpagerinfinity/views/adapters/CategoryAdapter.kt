package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.getURL
import com.example.viewpagerinfinity.models.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.categorys.view.*


class CategoryAdapter(
    private val listCategory: List<Category>, val context: Context
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        p0: ViewGroup, p1: Int
    ) = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.categorys, p0, false)
    )

    override fun getItemCount() = listCategory.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.dataBinding(listCategory[p1], context)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun dataBinding(category: Category, context: Context) {
            itemView.tvnameCategory.text = category.title
            itemView.tvTitleCate1.text = category.listArticle[0].title
            itemView.tvTitleCate2.text = category.listArticle[1].title
            Picasso.with(context).load(getURL(category.listArticle[0].thumbnail)).into(itemView.ivCategory1)
            Picasso.with(context).load(getURL(category.listArticle[1].thumbnail)).into(itemView.ivCategory2)
        }
    }

}