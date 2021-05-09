package com.example.rngclone.ui.excludedNumbers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.rngclone.R
import com.example.rngclone.databinding.FragmentExcludedNumbersBinding

class ExcludedNumbersFragment : Fragment(R.layout.fragment_excluded_numbers) {

    private var _binding: FragmentExcludedNumbersBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentExcludedNumbersBinding.bind(view)

        binding.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}