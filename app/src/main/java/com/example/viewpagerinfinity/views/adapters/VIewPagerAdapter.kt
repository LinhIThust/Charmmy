package com.example.viewpagerinfinity.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.viewpagerinfinity.models.TabHeader
import com.example.viewpagerinfinity.views.BlankFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager, private val listTab: MutableList<TabHeader>
) : FragmentStatePagerAdapter(fragmentManager) {

    private val size = listTab.size

    override fun getItem(p0: Int): Fragment =
        BlankFragment.newInstanceFragmet(listTab[p0 % size])

    override fun getCount() = 1000

    override fun getPageTitle(position: Int) = listTab[position % size].title
}
