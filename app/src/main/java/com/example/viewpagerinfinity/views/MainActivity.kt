package com.example.viewpagerinfinity.views

import android.content.res.Configuration
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.GravityCompat
import android.util.DisplayMetrics
import android.util.Log.d
import android.view.Gravity
import android.widget.Toast

import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.Companion.listHeader
import com.example.viewpagerinfinity.models.ListTabHeader
import com.example.viewpagerinfinity.services.APIService
import com.example.viewpagerinfinity.services.GetData
import com.example.viewpagerinfinity.views.adapters.TabHomeAdapter
import com.example.viewpagerinfinity.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        var orientation = 0
        var hightDevice = 0
        var widthDevice = 0

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://charmmy-api.line.me/api/v1/")
            .build()

        val api = retrofit.create(APIService::class.java)
    }

    lateinit var viewPagerAdapter: ViewPagerAdapter

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("state",savedInstanceState.toString())
        setContentView(R.layout.activity_main)
        getSizeDevice()
        setClick()

        api.getAllHeader().enqueue(object : Callback<ListTabHeader> {
            override fun onFailure(call: Call<ListTabHeader>, t: Throwable) {
                d("abcd", t.message)
            }
            override fun onResponse(call: Call<ListTabHeader>, response: retrofit2.Response<ListTabHeader>) {
                showData(response.body())
            }
        })
        GetData.getDataTabHome(TabHomeAdapter())
    }

    private fun setClick() {
        ivMenu.setOnClickListener{
            dlNavigation.openDrawer(GravityCompat.START)
        }
    }

    private fun getSizeDevice() {
        orientation = this.resources.configuration.orientation
        var displayMatrix = DisplayMetrics()
        var hight = windowManager.defaultDisplay.getMetrics(displayMatrix)
        widthDevice = if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            displayMatrix.widthPixels else displayMatrix.widthPixels
    }

    private fun showData(body: ListTabHeader?) {
        for (it in body!!.listTabHeader) listHeader.add(it)
        listHeader.removeAt(1)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listHeader, this)
        vpDemo.adapter = viewPagerAdapter
        recycler_tab_layout.setUpWithViewPager(vpDemo)
        recycler_tab_layout.setAutoSelectionMode(true)
        d("abcd", listHeader.toString())


    }

}
