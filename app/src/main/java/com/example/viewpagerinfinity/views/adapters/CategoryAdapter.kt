package com.example.viewpagerinfinity.views.adapters

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
    private val listCategory: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    var onItemClick: (id: Int) -> Unit = {}
    override fun onCreateViewHolder(
        p0: ViewGroup, p1: Int
    ) = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.categorys, p0, false),
        onItemClick =onItemClick
    )

    override fun getItemCount() = listCategory.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.dataBinding(listCategory[p1])
    }

    class ViewHolder(
        itemView: View,
        var onItemClick: (id: Int) -> Unit = {}
    ) : RecyclerView.ViewHolder(
        itemView
    ) {

        fun dataBinding(category: Category) {
            itemView.tvnameCategory.text = category.title
            itemView.tvTitleCate1.text = category.listArticle[0].title
            itemView.tvTitleCate2.text = category.listArticle[1].title
            Picasso.with(itemView.context).load(getURL(category.listArticle[0].thumbnail)).into(itemView.ivCategory1)
            Picasso.with(itemView.context).load(getURL(category.listArticle[1].thumbnail)).into(itemView.ivCategory2)
            itemView.ivCategory1.setOnClickListener { onItemClick(category.listArticle[0].id) }
            itemView.ivCategory2.setOnClickListener { onItemClick(category.listArticle[1].id) }
        }
    }

}