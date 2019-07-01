package com.example.viewpagerinfinity.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpagerinfinity.models.Face
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.views.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var listFace = arrayListOf<Face>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
        var viewPagerAdapter =
            ViewPagerAdapter(supportFragmentManager, listFace)
        vpDemo.adapter = viewPagerAdapter
        recycler_tab_layout.setUpWithViewPager(vpDemo)
        recycler_tab_layout.setAutoSelectionMode(true)
        ivMenu.setOnClickListener{}

    }

    private fun setData() {

        listFace.add(
            Face(
                "LC",
                "203",
                "https://randomuser.me/api/portraits/med/women/61.jpg"
            )
        )
        listFace.add(
            Face(
                "LinhFRTGF",
                "220",
                "https://randomuser.me/api/portraits/med/women/62.jpg"
            )
        )
        listFace.add(
            Face(
                "LinhFFFF",
                "202",
                "https://randomuser.me/api/portraits/med/women/63.jpg"
            )
        )
        listFace.add(
            Face(
                "LinhFFFSS",
                "240",
                "https://randomuser.me/api/portraits/med/women/66.jpg"
            )
        )
        listFace.add(
            Face(
                "Fnh",
                "320",
                "https://randomuser.me/api/portraits/med/women/68.jpg"
            )
        )
        listFace.add(
            Face(
                "FFGFLinh1234",
                "220",
                "https://randomuser.me/api/portraits/med/women/69.jpg"
            )
        )
        listFace.add(
            Face(
                "LFF",
                "201",
                "https://randomuser.me/api/portraits/med/women/67.jpg"
            )
        )
        listFace.add(
            Face(
                "1",
                "210",
                "https://randomuser.me/api/portraits/med/women/80.jpg"
            )
        )


    }
}
