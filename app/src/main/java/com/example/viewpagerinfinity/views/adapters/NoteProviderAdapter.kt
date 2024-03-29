package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Expert
import com.example.viewpagerinfinity.views.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.expert_list_layout.view.*

class NoteProviderAdapter(private val listExpert: List<Expert>) :
    RecyclerView.Adapter<NoteProviderAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.expert_list_layout, parent, false)
    )

    override fun getItemCount() = listExpert.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBinding(listExpert[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun dataBinding(expert: Expert) = with(itemView) {

            tvTitleExpert?.text = expert.name
            tvDesExpert?.text = expert.description
            ivRankingProfile?.layoutParams?.width = MainActivity.widthDevice / 4
            ivRankingProfile?.layoutParams?.height = MainActivity.widthDevice / 4
            Picasso.with(itemView.context).load(expert.icon).into(ivRankingProfile)

            ivRankingProfile.setOnClickListener {
                Toast.makeText(context, expert.id.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}