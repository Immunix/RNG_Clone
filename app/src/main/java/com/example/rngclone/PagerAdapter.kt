package com.example.rngclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")
class PagerAdapter(fm: FragmentManager?, private val numOfTabs: Int) : FragmentPagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> RngFragment()
            1 -> DiceFragment()
            2 -> LottoFragment()
            3 -> CoinsFragment()
            else -> throw IllegalAccessException("?????????idk?????????")
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }
}

// TODO: 15/08/2020 Look for a solution to the deprecation issue