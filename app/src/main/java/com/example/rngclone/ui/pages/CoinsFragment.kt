package com.example.rngclone.ui.pages

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.rngclone.R
import com.example.rngclone.utils.randomNumber
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_coins.*

class CoinsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coins, container, false)
    }

//    @SuppressLint("SetTextI18n")
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        input_coins.setText("1") // default case for no of flips
//        input_coins.setSelection(input_coins.text.length) // attempt to put cursor at end of line
//        var result: Int // var to store flip results and use it outside of the for loop
//        val flipResults = ArrayList<String>() // wondering if i can just use a string instead of this
//        var headsCount = 0 // tracking the no of heads/tails to display them
//        var tailsCount = 0
//
//        coins_scroll.visibility = View.GONE
//
//        generate_coins.setOnClickListener {
//
//            coins_scroll.visibility = View.VISIBLE
//
//            // check to see if we have at least 1 coin
//            if (input_coins.text.toString().toInt() != 0) {
//                // resetting the values here. idk yet if there is a better way
//                if (result_total_coins.text != null) {
//                    flipResults.clear()
//                    headsCount = 0
//                    tailsCount = 0
//                }
//
//                val numFlips = input_coins.text.toString().toInt() // input for no of flips
//                for (i in 1..numFlips) {
//                    result = randomNumber(0, 1)
//
//                    if (result == 0) {
//                        flipResults.add("Heads")  // trying to append to array
//                        headsCount++
//                    } else {
//                        flipResults.add("Tails")
//                        tailsCount++
//                    }
//                }
//                result_total_coins.text = flipResults.asIterable().joinToString(", ", prefix = "Side(s): ")
//                result_heads.text = "# of heads: $headsCount"
//                result_tails.text = "# of tails: $tailsCount"
//            } else {
//                Snackbar.make(coins_main_lay, "You must flip at least 1 coin!", Snackbar.LENGTH_SHORT)
//                    .setBackgroundTint(Color.BLACK)  // idk how to set my color to colorAccent. it looks weird
//                    .setTextColor(Color.WHITE)
//                    .show()
//            }
//
//            it.hideKeyboard()
//        }
//    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
