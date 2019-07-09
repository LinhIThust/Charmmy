package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Ranking
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ranking_layout.view.*


class RankingAdapter(val listRanking: List<Ranking>, val content: Context) :
    RecyclerView.Adapter<RankingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ranking_layout, parent, false))

    override fun getItemCount(): Int = 15
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.with(content).load(getURL(listRanking[position].thumbnail)).into(holder.ivRanking)
        holder.tvRank.text = listRanking[position].rank.toString()
        holder.tvRankingColection.text = listRanking[position].category.title
        holder.tvRankingDes.text = listRanking[position].title
    }

    private fun getURL(thumbnail: String): String {
        val lisUrl = thumbnail.split("\"")
        return lisUrl[lisUrl.size - 4]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivRanking = itemView.ivRankingProfile
        val tvRankingDes = itemView.tvRankingDes
        val tvRankingColection = itemView.tvRankingColection
        val tvRank = itemView.tvRank
    }
}