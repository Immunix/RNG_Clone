package com.example.rngclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PagerAdapter(fm: FragmentManager?, private val numOfTabs: Int) : FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> RngFragment()
            1 -> DiceFragment()
            2 -> LottoFragment()
            3 -> CoinsFragment()
            else -> throw IllegalAccessException("?????????wtf?????????")
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }

}