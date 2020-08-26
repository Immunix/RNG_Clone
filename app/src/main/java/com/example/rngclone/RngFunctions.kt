package com.example.rngclone

import kotlin.random.Random

fun randomNumber (startNum: Int, endNum: Int): Int {
    val random = Random
    return random.nextInt(startNum, endNum + 1)
}

/*
Changed from ThreadLocalRandom because it was generating the same sequence  of numbers unless the
phone was restarted. Closing the app normally or force closing it would not change the sequence.
 */