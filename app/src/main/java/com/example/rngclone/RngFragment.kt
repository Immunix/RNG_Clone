package com.example.rngclone

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_rng.*

class RngFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rng, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rng_generate_btn.setOnClickListener {
            val min = edit_txt_min.text.toString().toInt()
            val max = edit_txt_max.text.toString().toInt()
            val result = randomNumber(min, max)
            display_result.text = result.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): RngFragment {
            return RngFragment()
        }
    }
}

// TODO: 10/08/2020 set default values for the edit text
// TODO: 10/08/2020 check the input numbers to see if min < max
// TODO: 10/08/2020 add a loop to generate more numbers when requested
// TODO: 10/08/2020 add an array to store the numbers in and display that instead
// TODO: 10/08/2020 perhaps another array for a list of excluded numbers