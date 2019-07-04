package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Tag
import kotlinx.android.synthetic.main.tag_layout.view.*

class TagAdapter(val listTag : List<Tag>) :RecyclerView.Adapter<TagAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int
    )= ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.tag_layout,p0,false))
    override fun getItemCount() = listTag.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvTag.text= listTag[p1].title
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTag = itemView.tvTag
    }
}