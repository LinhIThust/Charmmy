package com.example.viewpagerinfinity.views.adapters

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.listCategory
import com.example.viewpagerinfinity.Utils.listExpert
import com.example.viewpagerinfinity.Utils.listRanking
import com.example.viewpagerinfinity.Utils.listTag
import com.example.viewpagerinfinity.Utils.loadContentArticle
import com.example.viewpagerinfinity.views.SearchActivity
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.category_recycle.view.*
import kotlinx.android.synthetic.main.parent_recycler.view.*


class TabHomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()
    val TYPE_1 = 1
    val TYPE_2 = 2
    var onItemClick: (titleCategory: Int) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v1 = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler, parent, false)
        val v2 = LayoutInflater.from(parent.context).inflate(R.layout.category_recycle, parent, false)

        if (viewType == TYPE_1) return View1Holder(v1, onItemClick)
        return View2Holder(v2)

    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 1) return TYPE_2
        return TYPE_1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_1) {
            holder as View1Holder
            holder.dataBinding(position)
//            holder.tvName.setOnClickListener {
//                Toast.makeText(holder.recyclerView.context, holder.tvName.text, Toast.LENGTH_LONG).show()
//            }
//            holder.recyclerView.apply {
//                if (position == 0) {
//                    holder.tvName.text = "ランキング"
//                    layoutManager = GridLayoutManager(holder.recyclerView.context, 5, LinearLayout.HORIZONTAL, false)
//                    if (listRanking != null)
//                        adapter = RankingAdapter(listRanking).apply {
//                            onItemClick = {
//
//                            }
//                        }
//                }
//                if (position == 2) {
//                    holder.tvName.text = "提供者"
//                    layoutManager = GridLayoutManager(holder.recyclerView.context, 1, LinearLayout.HORIZONTAL, false)
//                    adapter = NoteProviderAdapter(listExpert)
//                }
//
//                if (position == 3) {
//                    holder.tvName.text = "人気のタグ"
//                    holder.recyclerView.apply {
//                        layoutManager = FlexboxLayoutManager(holder.recyclerView.context).apply {
//                            justifyContent = JustifyContent.FLEX_START
//                            alignItems = AlignItems.CENTER
//                        }
//                        adapter = TagAdapter(listTag).apply {
//                            onItemClick = {
//                                val intent = Intent(context, SearchActivity::class.java)
//                                intent.putExtra("Tag", it.title)
//                                context.startActivity(intent)
//                            }
//                        }
//                    }
//                }
//                recycledViewPool
//            }
        }

        if (getItemViewType(position) == TYPE_2) {
            holder as View2Holder
            holder.dataBinding()
//            holder as View2Holder
//            holder.rvCategory
//            holder.rvCategory.apply {
//                layoutManager = GridLayoutManager(
//                    holder.rvCategory.context,
//                    1,
//                    LinearLayout.VERTICAL,
//                    false
//                ) as RecyclerView.LayoutManager?
//                adapter = CategoryAdapter(listCategory)
        }
    }
}

class View1Holder(
    itemView: View,
    private var onItemClick: (titleCategory: Int) -> Unit = {}
) : RecyclerView.ViewHolder(itemView) {
    val recyclerView: RecyclerView = itemView.rv_child
    val tvName: TextView = itemView.tvNameType
    fun dataBinding(position: Int) {
        tvName.setOnClickListener {
            onItemClick(position)
        }
        recyclerView.apply {
            if (position == 0) {
                tvName.text = "ランキング"
                layoutManager = GridLayoutManager(recyclerView.context, 10, LinearLayout.HORIZONTAL, false)

                adapter = RankingAdapter(listRanking).apply {
                    onItemClick = {
                        loadContentArticle(context, it.id.toInt())
                    }
                }
            }
            if (position == 2) {
                tvName.text = "提供者"
                layoutManager = GridLayoutManager(recyclerView.context, 1, LinearLayout.HORIZONTAL, false)
                adapter = NoteProviderAdapter(listExpert)
            }

            if (position == 3) {
                tvName.text = "人気のタグ"
                recyclerView.apply {
                    layoutManager = FlexboxLayoutManager(recyclerView.context).apply {
                        justifyContent = JustifyContent.FLEX_START
                        alignItems = AlignItems.CENTER
                    }
                    adapter = TagAdapter(listTag).apply {
                        onItemClick = {
                            val intent = Intent(context, SearchActivity::class.java)
                            intent.putExtra("Tag", it.title)
                            context.startActivity(intent)
                        }
                    }
                }
            }
            recycledViewPool
        }
    }

}

class View2Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val rvCategory = itemView.rvCategory
    fun dataBinding() {
        rvCategory.apply {
            layoutManager = GridLayoutManager(
                itemView.rvCategory.context,
                1,
                LinearLayout.VERTICAL,
                false
            )

            adapter = CategoryAdapter(listCategory).apply {
                onItemClick = {
                    loadContentArticle(context, it)
                }
            }
        }
    }
}
