package com.example.viewpagerinfinity.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d

import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.ListTabHeader
import com.example.viewpagerinfinity.models.TabHeader
import com.example.viewpagerinfinity.services.APIService
import com.example.viewpagerinfinity.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://charmmy-api.line.me/api/v1/")
            .build()

        val api = retrofit.create(APIService::class.java)
    }

    var listTab = mutableListOf<TabHeader>()
    lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        api.getAllHeader().enqueue(object : Callback<ListTabHeader> {
            override fun onFailure(call: Call<ListTabHeader>, t: Throwable) {
                d("abcd", t.message)
            }
            override fun onResponse(call: Call<ListTabHeader>, response: retrofit2.Response<ListTabHeader>) {
                showData(response.body())

            }
        })

    }

    private fun showData(body: ListTabHeader?) {
        for (it in body!!.list_tab) listTab.add(it)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listTab, this)
        vpDemo.adapter = viewPagerAdapter
        recycler_tab_layout.setUpWithViewPager(vpDemo)
        recycler_tab_layout.setAutoSelectionMode(true)
        d("abcd", listTab.toString())


    }

}
