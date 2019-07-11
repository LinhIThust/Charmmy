package com.example.viewpagerinfinity.views

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.KeyEvent
import android.view.View
import android.widget.LinearLayout
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.Article
import com.example.viewpagerinfinity.models.ResponseSearch
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import com.example.viewpagerinfinity.views.adapters.SearchResultAdapter
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Response

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var new = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        rvSearchResult.apply {
            layoutManager = GridLayoutManager(this@SearchActivity, 1, LinearLayout.VERTICAL, false)
            adapter = null
        }

        if (intent.getStringExtra("Tag") != "") {
            etContentSearch.setText(intent.getStringExtra("Tag"))
            loadData(etContentSearch.text.toString(), "new", 1)
        }
        tvSort.setOnClickListener {
            if (new) {
                loadData(etContentSearch.text.toString(), "popular", 1)
                new = false
                tvSort.text = getString(R.string.new_sort)
                tvSort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_down_black_24dp, 0)
            } else {
                loadData(etContentSearch.text.toString(), "new", 1)
                new = true
                tvSort.text = getString(R.string.popular_sort)
                tvSort.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_keyboard_arrow_up_black_24dp, 0)

            }
        }

        etContentSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                if (etContentSearch.text.toString() != "")
                    loadData(etContentSearch.text.toString(), "new", 1)
                else {
                    tvSearchNumber.text = getString(R.string.null_text_search)
                }
                return@OnKeyListener true
            }
            false
        })

    }

    private fun loadData(keyWord: String, sort: String, page: Int) {
        tvSort.visibility = View.VISIBLE
        api.getSearchResult(keyWord, sort, page)
            .enqueue(object : retrofit2.Callback<ResponseSearch> {
                override fun onFailure(call: Call<ResponseSearch>, t: Throwable) {
                }

                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<ResponseSearch>, response: Response<ResponseSearch>) {
                    val responseSearch = response.body()!!
                    tvSearchNumber.text = "" + responseSearch.info.totalRecords + getString(R.string.results)
                    val listArticleResult = mutableListOf<Article>()
                    listArticleResult.addAll(responseSearch.listResult)
                    if (responseSearch.info.totalRecords == 0) {
                        tvSearchNumber.text = getString(R.string.none_result_search)
                        rvSearchResult.adapter = null
                    } else {
                        rvSearchResult.adapter = SearchResultAdapter(listArticleResult)
                    }
                }

            })
    }
}
