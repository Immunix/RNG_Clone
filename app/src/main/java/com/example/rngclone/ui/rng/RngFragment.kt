package com.example.rngclone.ui.rng

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.rngclone.R
import com.example.rngclone.databinding.FragmentRngBinding
import com.example.rngclone.utils.hideKeyboard
import com.example.rngclone.utils.randomNumber

class RngFragment : Fragment(R.layout.fragment_rng) {

    private var _binding: FragmentRngBinding? = null
    private val binding get() = _binding!!
    private val rngViewModel by activityViewModels<RngViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRngBinding.bind(view)

        binding.apply {
            rngViewModel.apply {
                getMin().observe(viewLifecycleOwner, { min ->
                    inputMinimum.root.setText(min)
                })
                getMax().observe(viewLifecycleOwner, { max ->
                    inputMaximum.root.setText(max)
                })
                getIterations().observe(viewLifecycleOwner, { totalIterations ->
                    totalGenerated.root.setText(totalIterations)
                })
            }

            rngGenerateBtn.setOnClickListener {
                rngViewModel.apply {
                    setResults( randomNumber(
                        getMin().value!!.toInt(),
                        getMax().value!!.toInt(),
                        getIterations().value!!.toInt()
                    ) as List<String> )
                }

                displayResult.root.text = rngViewModel.getResults().value.toString()
                displayResult.root.visibility = View.VISIBLE

                it.hideKeyboard()
            }

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
