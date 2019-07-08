package com.example.viewpagerinfinity.views


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.listArticle
import com.example.viewpagerinfinity.models.*
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import com.example.viewpagerinfinity.views.adapters.ArticleAdapter
import com.example.viewpagerinfinity.views.adapters.PickupAdapter

import com.example.viewpagerinfinity.views.adapters.TabHomeAdapter
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val rvMain = view.findViewById<RecyclerView>(R.id.rvMain)
        val args = arguments

        rvMain.apply {
            layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
            val index = args?.getString("INDEX")
            when (index) {
                "0" -> {
                    adapter = TabHomeAdapter()
                }
                "2", "3", "4", "5", "6" -> {
//                    layoutManager = GridLayoutManager(context, 2, LinearLayout.VERTICAL, false)
                    layoutManager = FlexboxLayoutManager(context).apply {
                        justifyContent = JustifyContent.FLEX_START
                        alignItems = AlignItems.CENTER
                    }
                    api.getCatelogy(index.toInt()-1,20).enqueue(object:Callback<ResponseCategogy>{
                        override fun onFailure(call: Call<ResponseCategogy>, t: Throwable) {
                        }
                        override fun onResponse(call: Call<ResponseCategogy>, response: Response<ResponseCategogy>) {
                            listArticle= emptyArray<Article>().toMutableList()
                            listArticle.add(response.body()!!.article)
                            listArticle.addAll(response.body()!!.listArticle)
                            adapter = ArticleAdapter(listArticle,context)
                        }
                    })
//                    adapter = ArticleAdapter(listArticle, context)
                }
                "7" ->{
                    layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
                    api.getPickup(10).enqueue(object:Callback<ResponsePickUp>{
                        override fun onFailure(call: Call<ResponsePickUp>, t: Throwable) {

                        }

                        override fun onResponse(call: Call<ResponsePickUp>, response: Response<ResponsePickUp>) {
                            listArticle= emptyArray<Article>().toMutableList()
                            listArticle.addAll(response.body()!!.listArticle)
                            adapter= PickupAdapter(listArticle,context)
                        }

                    })
                }
            }
        }
        return view
    }
    companion object {
        fun newInstanceFragmet(tab: TabHeader): BlankFragment {
            val fragment: BlankFragment = BlankFragment()
            val args = Bundle()
            args.putString("INDEX", tab.index)
            fragment.arguments = args
            return fragment
        }
    }


}
