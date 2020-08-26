package com.example.rngclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_excluded_numbers.*

class ExcludedNumbersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluded_numbers)

        // showing toolbar
        setSupportActionBar(toolbar_excluded as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Edit Excluded Numbers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // back button just because
        supportActionBar?.setDisplayShowHomeEnabled(true)

        excluded_add_btn.setOnClickListener {
            // on click add the currently input num
        }

        save_btn.setOnClickListener {
            // send the numbers to the rng fragment

            finish() // just testing to see if it returns when i click save
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}