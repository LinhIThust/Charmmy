package com.example.viewpagerinfinity.views.adapters

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.*
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import kotlinx.android.synthetic.main.category_recycle.view.*
import kotlinx.android.synthetic.main.parent_recycler.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TabHomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    val TYPE_1 = 1
    val TYPE_2 = 2
    val TYPE_3 = 3
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v1 = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler, parent, false)
        val v2 = LayoutInflater.from(parent.context).inflate(R.layout.category_recycle, parent, false)

        if (viewType == TYPE_1) return View1Holder(v1)
        return View2Holder(v2)

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun getItemViewType(position: Int): Int {
        if(position ==1) return TYPE_2
        return TYPE_1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_1) {
            holder as View1Holder
            holder.recyclerView.apply {

                if (position == 0){
                    layoutManager = GridLayoutManager(holder.recyclerView.context, 5, LinearLayout.HORIZONTAL, false)
                    api.getScreenRanking().enqueue(object :Callback<ListRanking>{
                        override fun onFailure(call: Call<ListRanking>, t: Throwable) {
                        }

                        override fun onResponse(call: Call<ListRanking>, response: Response<ListRanking>) {
                            val listRanking = mutableListOf<Ranking>()
                            for(it in response.body()!!.list_ranking) listRanking.add(it)
                            d("abcd" , "ranking "+listRanking.toString())
                            adapter =RankingAdapter(listRanking,context)
                        }

                    })

                }

                if (position == 2) {
                    layoutManager = GridLayoutManager(holder.recyclerView.context, 1, LinearLayout.HORIZONTAL, false)
                    api.getScreenExpert().enqueue(object : Callback<ListExpert> {
                        override fun onFailure(call: Call<ListExpert>, t: Throwable) {
                            Log.d("abcd", t.message)
                        }
                        override fun onResponse(call: Call<ListExpert>, response: retrofit2.Response<ListExpert>) {
                            val listExpert = mutableListOf<Expert>()
                            for (it in response.body()!!.list_expert) listExpert.add(it)
                            adapter = NoteProviderAdapter(listExpert, context)
                        }
                    })
                }
                recycledViewPool
            }
        }
        if (getItemViewType(position) == TYPE_2) {
            holder as View2Holder
            holder.rvCategory.apply {
                layoutManager = GridLayoutManager(holder.rvCategory.context, 1, LinearLayout.VERTICAL, false)
                api.getScreenCategory().enqueue(object : Callback<ListCategory> {
                    override fun onFailure(call: Call<ListCategory>, t: Throwable) {
                        Log.d("abcd", t.message)
                    }

                    override fun onResponse(call: Call<ListCategory>, response: retrofit2.Response<ListCategory>) {
                        val listCategory = mutableListOf<Category>()
                        for (it in response.body()!!.list_category) listCategory.add(it)
                        d("abcd", response.body()!!.list_category.toString())
                        adapter = CategoryAdapter(listCategory, context)
                    }
                })
            }
        }
    }

    inner class View1Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val tvName: TextView = itemView.textView
    }

    class View2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvCategory = itemView.rvCategory
    }

    class View3Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}