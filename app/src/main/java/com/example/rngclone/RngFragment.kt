package com.example.rngclone

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rng.*

class RngFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rng, container, false)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        edit_txt_min.setText("1") // default values for EditTexts
        edit_txt_max.setText("1000")
        total_num.setText("1")

        val numGenerated = ArrayList<String>() // array to store the numbers
        var result: Int

        // trying to handle excluded numbers with an AlertDialog
        btn_excluded.setOnClickListener {

            val alert = AlertDialog.Builder(context)

            alert.setTitle("Excluded Numbers")
            alert.setMessage("You currently aren't preventing any numbers from being generated.")

            alert.setNeutralButton("CLEAR") {_, _ -> // to ask konrad what these _ do
                // this should clear the list
                // this is only placed on the far left
            }

            alert.setPositiveButton("OK") { _, _ ->
                // this does nothing
                // far right
            }

            alert.setNegativeButton("EDIT") {_, _ ->
                // start intent here
                // trying to replicate the placement of the rng app
                // to my understanding functionally they are the same
            }

            alert.create().show()
        }

        rng_generate_btn.setOnClickListener {

            // check for min < max
            if (edit_txt_min.text.toString().toInt() < edit_txt_max.text.toString().toInt()) {

                // again reset the TextView
                if (display_result != null) {
                    numGenerated.clear()
                }

                for (i in 1..total_num.text.toString().toInt()) { // loop how many times we need
                    result = randomNumber(
                        edit_txt_min.text.toString().toInt(),
                        edit_txt_max.text.toString().toInt()
                    )
                    numGenerated.add(result.toString())
                }

                display_result.text =
                    numGenerated.asIterable().joinToString(", ", prefix = "Number(s): ")
            } else {
                Snackbar.make(rng_rel_lay, "The maximum must be greater than the minimum!", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.BLACK)  // idk how to set my color to colorAccent. it looks weird
                    .setTextColor(Color.WHITE)
                    .show()
            }
        }
    }
}

// TODO: 10/08/2020 perhaps another array for a list of excluded numbers