package com.example.viewpagerinfinity.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.viewpagerinfinity.views.BlankFragment
import com.example.viewpagerinfinity.models.TabHeader

class ViewPagerAdapter(
    fragmentManager: FragmentManager, val listTab: MutableList<TabHeader>) : FragmentStatePagerAdapter(fragmentManager) {
    val size = listTab.size
    val n = Int.MAX_VALUE
    override fun getItem(p0: Int): Fragment =
        BlankFragment.newInstanceFragmet(listTab[p0 % size])

    override fun getCount() = 1000
    override fun getPageTitle(position: Int) = listTab[position % size].title
}