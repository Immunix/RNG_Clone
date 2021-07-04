package com.example.rngclone.ui.rng

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.rngclone.R
import com.example.rngclone.databinding.FragmentRngBinding
import com.example.rngclone.utils.hideKeyboard
import com.example.rngclone.utils.getRandomNumber
import com.google.android.material.snackbar.Snackbar

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
                    setMin(inputMinimum.root.text.toString())
                    setMax(inputMaximum.root.text.toString())
                    setIterations(totalGenerated.root.text.toString())

                    if (getMin().value!!.toInt() >= getMax().value!!.toInt()) {
                        Snackbar.make(
                            it,
                            "The maximum must be larger than the minimum!",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    } else {
                        setResults(
                            getRandomNumber(
                                getMin().value!!.toInt(),
                                getMax().value!!.toInt(),
                                getIterations().value!!.toInt()
                            )
                        )
                    }
                }

                displayResult.root.apply {
                    text = rngViewModel.getResults().value?.joinToString()
                    visibility = View.VISIBLE
                }

                it.hideKeyboard()
            }

            btnExcluded.setOnClickListener {
                val alert = AlertDialog.Builder(context)

                alert.setTitle("Excluded Numbers")
                alert.setMessage("You currently aren't preventing any numbers from being generated.")

                alert.setNeutralButton("CLEAR") { _, _ ->
                    // clear the list of numbers
                }

                alert.setPositiveButton("OK") { _, _ ->
                    // do nothing?
                }

                alert.setNegativeButton("EDIT") { _, _ ->
                    findNavController().navigate(R.id.excludedNumbersFragment)
                }

                alert.create().show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}