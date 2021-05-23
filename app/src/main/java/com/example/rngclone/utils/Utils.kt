package com.example.rngclone.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.random.Random

/*
Changed from ThreadLocalRandom because it was generating the same sequence of numbers until the
phone was restarted. Closing the app normally or force closing it would not change the sequence.
 */

fun randomNumber (min: Int, max: Int, iterations: Int): List<Int> {
    val resultList: ArrayList<Int> = ArrayList()

    for (num in 0..iterations) {
        resultList.add(Random.nextInt(min, max + 1))
    }
    return resultList
}

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}