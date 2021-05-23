package com.example.rngclone.ui.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.rngclone.R
import com.example.rngclone.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.Exception

class ViewPagerFragment: Fragment(R.layout.fragment_view_pager) {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPagerAdapter: PagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewPagerBinding.bind(view)

        val tabNames = listOf(
            getString(R.string.rng_fragment_title),
            getString(R.string.dice_fragment_title),
            getString(R.string.lotto_fragment_title),
            getString(R.string.coins_fragment_title)
        )

        binding.apply {
            viewPagerAdapter = PagerAdapter(this@ViewPagerFragment)
            viewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(viewPager, tabNames)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun TabLayout.setupWithViewPager(viewPager: ViewPager2, labels: List<String>) {

        if (labels.size != viewPager.adapter?.itemCount)
            throw Exception("Size of the list and tab count should be equal")

        TabLayoutMediator(
            this, viewPager
        ) { tab, position ->
            tab.text = labels[position]
        }.attach()
    }
}