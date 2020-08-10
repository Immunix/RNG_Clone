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