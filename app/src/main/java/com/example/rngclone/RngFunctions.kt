package com.example.rngclone

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.concurrent.ThreadLocalRandom

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun randomNumber (startNum: Int, endNum: Int): Int {
    return ThreadLocalRandom.current().nextInt(startNum, (endNum + 1))
}

// TODO: 19/08/2020 change ThreadLocalRandom to Math.random or something else as it seems to generate the same sequence of numbers