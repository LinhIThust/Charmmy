package com.example.viewpagerinfinity.views


import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log.d
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.Utils.listHeader
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
        var widthDevice = 0
        private val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://charmmy-api.line.me/api/v1/")
            .build()
        val api = retrofit.create(APIService::class.java)
    }

    lateinit var viewPagerAdapter: ViewPagerAdapter

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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
        ivMenu?.setOnClickListener {
            dlNavigation?.openDrawer(GravityCompat.START)
        }
        tvCharmmy?.setOnClickListener {
            vpDemo?.let{vpDemo
                for (i in 0..7)
                    if ((vpDemo.currentItem - i) % 8 == 0) vpDemo.currentItem = vpDemo.currentItem - i
            }
        }
        ivSearch.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra("Tag", "")
            startActivity(intent)
        }
    }

    private fun getSizeDevice() {
        orientation = this.resources.configuration.orientation
        val displayMatrix = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMatrix)
        widthDevice = if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            displayMatrix.widthPixels else displayMatrix.widthPixels
    }

    private fun showData(body: ListTabHeader?) {
        for (it in body!!.listTabHeader) listHeader.add(it)
        listHeader.removeAt(3)
        listHeader.removeAt(2)
        listHeader.removeAt(1)
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listHeader)
        vpDemo?.adapter = viewPagerAdapter
        vpDemo?.currentItem = 160
        rtlTab?.setUpWithViewPager(vpDemo)
        rtlTab?.setAutoSelectionMode(true)
    }

}
