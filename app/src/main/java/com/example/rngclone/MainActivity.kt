package com.example.rngclone

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.rngclone.adapters.PagerAdapter
import com.example.rngclone.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar stuff
        setSupportActionBar(binding.toolbarMain.root as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        val tabNames = listOf(
            getString(R.string.rng_fragment_title),
            getString(R.string.dice_fragment_title),
            getString(R.string.lotto_fragment_title),
            getString(R.string.coins_fragment_title)
        )

        binding.apply {
            viewPagerAdapter = PagerAdapter(this@MainActivity)
            viewPager.adapter = viewPagerAdapter
            tabLayout.setupWithViewPager(viewPager, tabNames)
        }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }
}
