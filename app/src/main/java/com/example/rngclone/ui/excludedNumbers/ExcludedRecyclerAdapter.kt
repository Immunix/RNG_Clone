package com.example.rngclone.ui.excludedNumbers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rngclone.data.ExcludedValues
import com.example.rngclone.databinding.ExcludedNumberItemCellBinding

class ExcludedRecyclerAdapter(private val excludedList: ArrayList<ExcludedValues>) :
    RecyclerView.Adapter<ExcludedRecyclerAdapter.ExcludedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcludedViewHolder {
        return ExcludedViewHolder(
            ExcludedNumberItemCellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExcludedViewHolder, position: Int) {
        val currentItem = excludedList[position]

        holder.binding.apply {
            excludedNumber.text = currentItem.toString()
            numberRemoveBtn.setOnClickListener {
                excludedList.removeAt(position)
                notifyDataSetChanged() // probably unnecessary if I use LiveData
            }
        }
    }

    override fun getItemCount() = excludedList.size

    inner class ExcludedViewHolder(val binding: ExcludedNumberItemCellBinding) :
        RecyclerView.ViewHolder(binding.root)
}