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

        // ??
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}