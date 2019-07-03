package com.example.viewpagerinfinity.views.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Expert
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class NoteProviderAdapter(val listExpert: List<Expert>, val context: Context) :
    RecyclerView.Adapter<NoteProviderAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.expert_list_layout, parent, false))

    override fun getItemCount() = listExpert.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = listExpert[position].name
        holder.tvDescription.text = listExpert[position].description
        Picasso.with(context).load(listExpert[position].icon).into(holder.ivProfile)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.findViewById<TextView>(R.id.tvNameExpert)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDesExpert)
        var ivProfile = itemView.findViewById<CircleImageView>(R.id.ivRankingProfile)
    }
}