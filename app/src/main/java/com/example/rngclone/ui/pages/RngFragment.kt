package com.example.rngclone.ui.pages

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.rngclone.ui.excludedNumbers.ExcludedNumbersActivity
import com.example.rngclone.R
import com.example.rngclone.utils.randomNumber
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_rng.*

class RngFragment : Fragment() {

    private val numGenerated = ArrayList<String>() // array to store the numbers

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rng, container, false)
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edit = view.findViewById<EditText>(R.id.input_minimum)

        // Get back the excluded list of numbers
        val a = RngFragment().arguments // fix  this when i come back from vienna
        val excludedList = a?.getStringArrayList("ExcludedList")//Bundle().getStringArrayList("ExcludedList")
        if (excludedList != null) {
            btn_excluded.text = excludedList.asIterable().joinToString(", ")
        }


        edit.setText("1") // default values for EditTexts
        edit.setSelection(edit.text.length) // cursor at end of ET


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
                val intent = Intent(context, ExcludedNumbersActivity::class.java)
                intent.putExtra("Min", edit.text.toString().toInt())
                //intent.putExtra("Max", input_maximum.text.toString().toInt())
                startActivity(intent)
            }

            alert.create().show()
        }

        //rng_scroll.visibility = View.GONE // making the ScrollView invisible until button clicked

        rng_generate_btn.setOnClickListener {

            //rng_scroll.visibility = View.VISIBLE

            // check for min < max
//            if (edit.text.toString().toInt() < input_maximum.text.toString().toInt()) {
//
//                // again reset the TextView
//                if (display_result != null) {
//                    numGenerated.clear()
//                }
//
//                for (i in 1..total_generated.text.toString().toInt()) { // loop how many times we need
//                    result = randomNumber(
//                        edit.text.toString().toInt(),
//                        input_maximum.text.toString().toInt()
//                    )
//                    numGenerated.add(result.toString())
//                }
//
//                display_result.text =
//                    numGenerated.asIterable().joinToString(", ", prefix = "Number(s): ")
//            } else {
//                Snackbar.make(rng_rel_lay, "The maximum must be greater than the minimum!", Snackbar.LENGTH_SHORT)
//                    .setBackgroundTint(Color.BLACK)  // idk how to set my color to colorAccent. it looks weird
//                    .setTextColor(Color.WHITE)
//                    .show()
//            }

            it.hideKeyboard()
        }
    }

    // hide the keyboard when generating results
    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

}
