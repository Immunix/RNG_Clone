package com.example.rngclone.ui.excludedNumbers

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.rngclone.R
import com.example.rngclone.adapters.ExcludedRecyclerAdapter
import com.example.rngclone.ui.pages.RngFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_excluded_numbers.*

class ExcludedNumbersActivity : AppCompatActivity() {

    private val excludedNumbers = ArrayList<String>()
    private val adapter = ExcludedRecyclerAdapter(excludedNumbers)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluded_numbers)

        val min = intent.getIntExtra("Min", 1)
        val max = intent.getIntExtra("Max", 1000)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter

        // showing toolbar
        setSupportActionBar(toolbar_excluded as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Edit Excluded Numbers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // back button just because
        supportActionBar?.setDisplayShowHomeEnabled(true)

        excluded_add_btn.setOnClickListener {
            val input = excluded_input.text.toString()

            // check for empty input
            if (input.isEmpty()) {
                Snackbar.make(
                    excluded_relative,
                    "Please make sure that your input is a valid number.",
                    Snackbar.LENGTH_SHORT
                )
                    .setBackgroundTint(Color.BLACK)
                    .setTextColor(Color.WHITE)
                    .show()
            } else {
                // check to see if it matches the correct range
                if (input.toInt() !in min until (max + 1)) {

                    Snackbar.make(
                        excluded_relative,
                        "Please enter in a number in the proper range. ($min to $max)",
                        Snackbar.LENGTH_SHORT
                    )
                        .setBackgroundTint(Color.BLACK)
                        .setTextColor(Color.WHITE)
                        .show()
                } else {
                    // check if number already added
                    if (input !in excludedNumbers) {
                        excludedNumbers.add(input)
                        excluded_input.text.clear()
                        (recyclerView.adapter as ExcludedRecyclerAdapter).notifyDataSetChanged()
                    } else {
                        Snackbar.make(
                            excluded_relative,
                            "You are already excluding this number.",
                            Snackbar.LENGTH_SHORT
                        )
                            .setBackgroundTint(Color.BLACK)
                            .setTextColor(Color.WHITE)
                            .show()
                    }
                }
            }



            // idk how to send the nums back yet
            save_btn.setOnClickListener {
                // send the numbers to the rng fragment
                val bundle = Bundle()
                bundle.putStringArrayList("ExcludedList", excludedNumbers)
                RngFragment().arguments = bundle

                supportFragmentManager.beginTransaction()
                    .commit()

                finish() // just testing to see if it returns when i click save
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}