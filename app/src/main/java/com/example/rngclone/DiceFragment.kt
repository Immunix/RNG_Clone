package com.example.rngclone

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_dice.*

class DiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dice, container, false)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        num_dice_rolls.setText("1") // default for num of dice being rolled
        num_dice_sides.setText("6") // default for # of die sides

        val resultsArray = ArrayList<String>() // array to store the roll results
        var dieSum = 0 // variable to hold the sum of the rolls
        var result: Int // hold the result returned from random fun

        // i am sure there is a much better way of doing this and that this is horrible code
        // but for now this works
        // i think i can handle these with a when/switch
        dice_1.setOnClickListener { num_dice_rolls.setText("1") }
        dice_2.setOnClickListener { num_dice_rolls.setText("2") }
        dice_3.setOnClickListener { num_dice_rolls.setText("3") }
        dice_4.setOnClickListener { num_dice_rolls.setText("4") }

        sides_1.setOnClickListener { num_dice_sides.setText("4") }
        sides_2.setOnClickListener { num_dice_sides.setText("6") }
        sides_3.setOnClickListener { num_dice_sides.setText("8") }
        sides_4.setOnClickListener { num_dice_sides.setText("10") }
        sides_5.setOnClickListener { num_dice_sides.setText("12") }
        sides_6.setOnClickListener { num_dice_sides.setText("20") }

        // rng logic
        btn_roll.setOnClickListener {

            // check to see if we have sides and num of rolls
            if (num_dice_rolls.text.toString().toInt() != 0 && num_dice_sides.text.toString()
                    .toInt() != 0
            ) {

                // reset TextView if btn_roll is clicked more times
                if (roll_result.text != null) {
                    resultsArray.clear()
                    dieSum = 0
                }

                for (i in 1..num_dice_rolls.text.toString()
                    .toInt()) { // not sure if this is the best way
                    result = randomNumber(1, num_dice_sides.text.toString().toInt())
                    resultsArray.add(result.toString())
                    dieSum += result
                }

                roll_result.text =
                    resultsArray.asIterable().joinToString(", ", prefix = "Roll(s): ")
                roll_sum.text = "Sum: $dieSum"
            } else {
                Snackbar.make(dice_main_lay, "You must roll at least 1 die and it needs at least 1 side!", Snackbar.LENGTH_SHORT)
                    .setBackgroundTint(Color.BLACK)  // idk how to set my color to colorAccent. it looks weird
                    .setTextColor(Color.WHITE)
                    .show()
            }
        }
    }
}
