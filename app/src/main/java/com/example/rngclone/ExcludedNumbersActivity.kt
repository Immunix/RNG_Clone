package com.example.rngclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_excluded_numbers.*

class ExcludedNumbersActivity : AppCompatActivity() {

    private val excludedNumbers = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluded_numbers)

        // Dealing with the RecyclerView.
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(excludedNumbers)


        // showing toolbar
        setSupportActionBar(toolbar_excluded as Toolbar?)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Edit Excluded Numbers"
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // back button just because
        supportActionBar?.setDisplayShowHomeEnabled(true)

        excluded_add_btn.setOnClickListener {
            // on click add the currently input num
            excludedNumbers.add(excluded_input.text.toString())
            (recyclerView.adapter as Adapter).notifyDataSetChanged()
        }

        save_btn.setOnClickListener {
            // send the numbers to the rng fragment

            finish() // just testing to see if it returns when i click save
        }
    }

    class Adapter(private val list: ArrayList<String>): RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun getItemCount() = list.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_cell, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView?.text = list[position]
        }

        class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
            var textView: TextView? = null
            init {
                textView = itemView?.findViewById(R.id.recyclerText)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}