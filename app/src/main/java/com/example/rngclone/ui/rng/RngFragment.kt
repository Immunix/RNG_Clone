package com.example.rngclone.ui.rng

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.rngclone.R
import com.example.rngclone.databinding.FragmentRngBinding

class RngFragment : Fragment(R.layout.fragment_rng) {

    private var _binding: FragmentRngBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRngBinding.bind(view)

        binding.apply {
            btnExcluded.setOnClickListener {
                val alert = AlertDialog.Builder(context)

                alert.setTitle("Excluded Numbers")
                alert.setMessage("You currently aren't preventing any numbers from being generated.")

                alert.setNeutralButton("CLEAR") { _, _ -> }

                alert.setPositiveButton("OK") { _, _ -> }

                alert.setNegativeButton("EDIT") { _, _ -> }

                alert.create().show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
