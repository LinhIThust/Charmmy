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
import android.widget.LinearLayout
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.*
import com.example.viewpagerinfinity.views.adapters.ArticleAdapter
import com.example.viewpagerinfinity.views.adapters.RankingAdapter
import com.example.viewpagerinfinity.views.adapters.TabHomeAdapter
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val rvMain = view.findViewById<RecyclerView>(R.id.rvMain)
        val args = arguments

        rvMain.apply {
            layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
            val index = args?.getString("INDEX")
            when (index) {
                "0" -> adapter = TabHomeAdapter()
                "2" -> {
                    layoutManager =
                        GridLayoutManager(context, 2, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

                    MainActivity.api.getArticle().enqueue(object : Callback<ListArticle> {
                        override fun onFailure(call: Call<ListArticle>, t: Throwable) {
                        }

                        override fun onResponse(call: Call<ListArticle>, response: Response<ListArticle>) {
                            val listArticle = mutableListOf<Article>()
                            for (it in response.body()!!.list_article) listArticle.add(it)
                            Log.d("abcd", "ranking " + listArticle.toString())
                            adapter = ArticleAdapter(listArticle, context)
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
