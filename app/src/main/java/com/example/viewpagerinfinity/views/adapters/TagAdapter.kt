package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Tag
import kotlinx.android.synthetic.main.tag_layout.view.*

class TagAdapter(val listTag: List<Tag>) : RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    var onItemClick: (itemData: Tag) -> Unit = {}

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int
    ) = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.tag_layout, p0, false),
        onItemClick = onItemClick
    )

    override fun getItemCount() = listTag.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.onBindData(listTag[p1])
    }


    class ViewHolder(
        itemView: View
        , private val onItemClick: (itemData: Tag) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun onBindData(itemData: Tag) {
            itemView.tvTag.text = itemData.title
            itemView.setOnClickListener { onItemClick(itemData) }
        }
    }
}