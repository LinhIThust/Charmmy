package com.example.viewpagerinfinity.views.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.viewpagerinfinity.views.BlankFragment
import com.example.viewpagerinfinity.models.Face

class ViewPagerAdapter(
    fragmentManager: FragmentManager, val listFace: ArrayList<Face>
) : FragmentStatePagerAdapter(fragmentManager) {
    val size = listFace.size - 1
    override fun getItem(p0: Int): Fragment =
        BlankFragment.newInstanceFragmet(listFace[p0 % size])
    override fun getCount() = Int.MAX_VALUE
    override fun getPageTitle(position: Int) = listFace[position % size].name
}