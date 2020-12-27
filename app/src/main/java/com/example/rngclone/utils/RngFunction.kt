package com.example.rngclone.utils

import kotlin.random.Random

/*
Changed from ThreadLocalRandom because it was generating the same sequence of numbers until the
phone was restarted. Closing the app normally or force closing it would not change the sequence.
 */

fun randomNumber (startNum: Int, endNum: Int): Int {
    val random = Random
    return random.nextInt(startNum, endNum + 1)
}