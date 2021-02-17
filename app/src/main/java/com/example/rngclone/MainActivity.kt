package com.example.rngclone

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.rngclone.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar stuff
        setSupportActionBar(toolbar_main as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        // TabLayout and ViewPager IDs
        val tabBar = findViewById<TabLayout>(R.id.tab_layout)
        val viewPag = findViewById<ViewPager>(R.id.viewPager)

        // PagerAdapter stuff. need to know more about this
        val pagerAdapter =
            PagerAdapter(supportFragmentManager, tabBar.tabCount)
        viewPag.adapter = pagerAdapter
        viewPag.offscreenPageLimit = 3 // this makes the tabs not reset but i don't like it!!

        // careful next time. i used the id of viewPager instead of using the variable so it didn't work at first
        viewPag.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(tab_layout)
        )
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPag.currentItem = tab.position
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Display menu icons
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }
}
