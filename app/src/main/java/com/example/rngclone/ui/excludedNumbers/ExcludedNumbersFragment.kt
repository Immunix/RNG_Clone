package com.example.rngclone.ui.excludedNumbers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.rngclone.R
import com.example.rngclone.data.ExcludedValues
import com.example.rngclone.databinding.FragmentExcludedNumbersBinding

class ExcludedNumbersFragment : Fragment(R.layout.fragment_excluded_numbers) {

    private var _binding: FragmentExcludedNumbersBinding? = null
    private val binding get() = _binding!!
    private lateinit var excludedAdapter: ExcludedRecyclerAdapter
    private val excludedViewModel: ExcludedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExcludedNumbersBinding.bind(view)

        binding.apply {
            excludedAddBtn.setOnClickListener {
                excludedViewModel.setExcludedNumber(excludedInput.text.map {
                    ExcludedValues(it.toString().toInt())
                })

            }

            saveBtn.setOnClickListener {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}