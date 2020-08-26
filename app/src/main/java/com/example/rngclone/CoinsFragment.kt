package com.example.rngclone

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_coins.*

class CoinsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coins, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coins_input.setText("1") // default case for no of flips
        coins_input.setSelection(coins_input.text.length) // attempt to put cursor at end of line
        var result: Int // var to store flip results and use it outside of the for loop
        val flipResults = ArrayList<String>() // wondering if i can just use a string instead of this
        var headsCount = 0 // tracking the no of heads/tails to display them
        var tailsCount = 0

        coins_scroll.visibility = View.GONE

        coins_button.setOnClickListener {

            coins_scroll.visibility = View.VISIBLE

            // check to see if we have at least 1 coin
            if (coins_input.text.toString().toInt() != 0) {
                // resetting the values here. idk yet if there is a better way
                if (coins_result.text != null) {
                    flipResults.clear()
                    headsCount = 0
                    tailsCount = 0
                }

                val numFlips = coins_input.text.toString().toInt() // input for no of flips
                for (i in 1..numFlips) {
                    result = randomNumber(0, 1)

                    if (result == 0) {
                        flipResults.add("Heads")  // trying to append to array
                        headsCount++
                    } else {
                        flipResults.add("Tails")
                        tailsCount++
                    }
                }
                coins_result.text = flipResults.asIterable().joinToString(", ", prefix = "Side(s): ")
                no_heads.text = "# of heads: $headsCount"
                no_tails.text = "# of tails: $tailsCount"
            } else {
                Snackbar.make(coins_main_lay, "The maximum must be greater than the minimum!", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.BLACK)  // idk how to set my color to colorAccent. it looks weird
                    .setTextColor(Color.WHITE)
                    .show()
            }

            it.hideKeyboard()
        }
    }

    private fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
