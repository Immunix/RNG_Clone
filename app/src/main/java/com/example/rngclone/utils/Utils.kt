package com.example.rngclone.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlin.random.Random

/*
Changed from ThreadLocalRandom because it was generating the same sequence of numbers until the
phone was restarted. Closing the app normally or force closing it would not change the sequence.
 */

fun randomNumber (startNum: Int, endNum: Int): Int {
    val random = Random
    return random.nextInt(startNum, endNum + 1)
}

fun View.hideKeyboard() {
    val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputManager.hideSoftInputFromWindow(windowToken, 0)
}