package com.example.rngclone.ui.excludedNumbers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rngclone.R
import kotlinx.android.synthetic.main.excluded_number_item_cell.view.*

class ExcludedRecyclerAdapter(private val excludedList: ArrayList<String>) : RecyclerView.Adapter<ExcludedRecyclerAdapter.ExcludedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcludedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.excluded_number_item_cell, parent, false)

        return ExcludedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExcludedViewHolder, position: Int) {
        val currentItem = excludedList[position]

        holder.textView.text = currentItem

        holder.removeButton.setOnClickListener {
            excludedList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = excludedList.size

    class ExcludedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.excluded_number
        val removeButton: Button = itemView.number_remove_btn
    }
}