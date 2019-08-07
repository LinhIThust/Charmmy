package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.models.Expert
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.expert_tab.view.*

class ExpertTabAdapter(private val listExpert: List<Expert>, val article: Article) :
    RecyclerView.Adapter<ExpertTabAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = ViewHolder(
        LayoutInflater.from(p0.context).inflate(R.layout.expert_tab, p0, false)
    )

    override fun getItemCount() = listExpert.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindData(listExpert[p1])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(expert: Expert) = with(itemView) {

            Picasso.with(context).load(expert.icon).into(ivExpertTab)
            tvNameExpert?.text = expert.name
            tvLike?.text = expert.likes.toString()
            tvTitleExpert?.text = expert.title
            tvTopicExpert?.text = expert.topic
        }
    }
}
