package com.example.rngclone

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_rng.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar stuff
        setSupportActionBar(toolbar_main as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        // initializing TabLayout and ViewPager
        val tabBar = findViewById<TabLayout>(R.id.tab_layout)
        val viewPag = findViewById<ViewPager>(R.id.viewPager)

        // PagerAdapter stuff. need to know more about this
        val pagerAdapter =
            PagerAdapter(supportFragmentManager, tabBar.tabCount)
        viewPag.adapter = pagerAdapter
        viewPag.offscreenPageLimit = 3 // this makes the tabs not reset but i don't like it!!

        // careful next time. i used the id of viewPager instead of using the variable so it didn't work at first
        viewPag.addOnPageChangeListener(
            TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPag.currentItem = tab.position
        }})

        // not sure if this does anything for me. gotta ask konrad
        //if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .commitAllowingStateLoss()
        //}

//        if (savedInstanceState != null) {
//            supportFragmentManager.getFragment(savedInstanceState, "RngFrag")
//            supportFragmentManager.getFragment(savedInstanceState, "DiceFrag")
//            supportFragmentManager.getFragment(savedInstanceState, "LottoFrag")
//            supportFragmentManager.getFragment(savedInstanceState, "CoinsFrag")
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Display menu icons
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }
/*
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        supportFragmentManager.putFragment(outState, "RngFrag", RngFragment())
//        supportFragmentManager.putFragment(outState, "DiceFrag", DiceFragment())
//        supportFragmentManager.putFragment(outState, "LottoFrag", LottoFragment())
//        supportFragmentManager.putFragment(outState, "CoinsFrag", CoinsFragment())
//    }

//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        supportFragmentManager.getFragment(savedInstanceState, "RngFrag")
//        supportFragmentManager.getFragment(savedInstanceState, "DiceFrag")
//        supportFragmentManager.getFragment(savedInstanceState, "LottoFrag")
//        supportFragmentManager.getFragment(savedInstanceState, "CoinsFrag")
//    }

 */

//    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
//        super.onSaveInstanceState(outState, outPersistentState)
//
//        outState.putString("rng", display_result.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        display_result.text = savedInstanceState.getString("rng")
//    }
}
