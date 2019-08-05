package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.getURL
import com.example.viewpagerinfinity.models.Ranking
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ranking_layout.view.*


class RankingAdapter(private val listRanking: List<Ranking>) :
    RecyclerView.Adapter<RankingAdapter.ViewHolder>() {

    var onItemClick: (ranking: Ranking) -> Unit = {}
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.ranking_layout, parent, false),
        onItemClick
    )

    override fun getItemCount(): Int = listRanking.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (listRanking.isNotEmpty())
            holder.dataBinding(listRanking[position])
    }

    class ViewHolder(
        itemView: View,
        private val onItemClick: (ranking: Ranking) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        fun dataBinding(ranking: Ranking) {
            Picasso.with(itemView.context).load(getURL(ranking.thumbnail)).into(itemView.ivRankingProfile)
            itemView.tvRankingDes.text = ranking.title
            itemView.tvRankingColection.text = ranking.category.title
            itemView.tvRank.text = ranking.rank.toString()
            itemView.setOnClickListener { onItemClick(ranking) }
        }

    }
}