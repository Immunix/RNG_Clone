package com.example.rngclone.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rngclone.ui.coins.CoinsFragment
import com.example.rngclone.ui.dice.DiceFragment
import com.example.rngclone.ui.lotto.LottoFragment
import com.example.rngclone.ui.rng.RngFragment

class PagerAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> RngFragment()
            1 -> DiceFragment()
            2 -> LottoFragment()
            3 -> CoinsFragment()
            else -> throw IllegalAccessException("ViewPager")
        }
    }

    override fun getItemCount(): Int = 4
}
