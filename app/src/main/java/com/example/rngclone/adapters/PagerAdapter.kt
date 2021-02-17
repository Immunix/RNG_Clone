package com.example.rngclone.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rngclone.ui.pages.CoinsFragment
import com.example.rngclone.ui.pages.DiceFragment
import com.example.rngclone.ui.pages.LottoFragment
import com.example.rngclone.ui.pages.RngFragment


// switch to VP2 and the recycler adapter

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
