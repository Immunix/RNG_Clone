package com.example.rngclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.TableLayout
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar stuff
        setSupportActionBar(toolbar_main as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        // initializing TabLayout, TabItems and ViewPager
        val tabBar = findViewById<TabLayout>(R.id.tab_layout)
        val rngTab = findViewById<TabItem>(R.id.rng_tab)
        val diceTab = findViewById<TabItem>(R.id.dice_tab)
        val lottoTab = findViewById<TabItem>(R.id.lotto_tab)
        val coinsTab = findViewById<TabItem>(R.id.coins_tab)
        val viewPag = findViewById<ViewPager>(R.id.viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Display menu icons
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }

/*
// make it work ?
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.history_btn -> Toast.makeText(this, "History pressed", Toast.LENGTH_SHORT)
            R.id.settings_btn -> Toast.makeText(this, "Settings pressed", Toast.LENGTH_SHORT)
            R.id.setting1 -> Toast.makeText(this, "Setting 1 pressed", Toast.LENGTH_SHORT)
            R.id.setting2 -> Toast.makeText(this, "Setting 2 pressed", Toast.LENGTH_SHORT)
            else -> return super.onOptionsItemSelected(item)
        }
    }
 */
}