package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.getURL
import com.example.viewpagerinfinity.models.Ranking
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ranking_layout.view.*


class RankingAdapter(val listRanking: List<Ranking>, val content: Context) :
    RecyclerView.Adapter<RankingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ranking_layout, parent, false))

    override fun getItemCount(): Int = listRanking.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (listRanking.size != 0)
            holder.dataBinding(listRanking[position], content)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun dataBinding(ranking: Ranking?, content: Context) {
            Picasso.with(content).load(ranking?.thumbnail?.let { getURL(it) }).into(itemView.ivRankingProfile)
            itemView.tvRankingDes.text = ranking?.title
            itemView.tvRankingColection.text = ranking?.category?.title
            itemView.tvRank.text = ranking?.rank.toString()
        }

    }
}