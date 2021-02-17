package com.example.rngclone.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RngParameters(private val min: Int, private val max: Int) : Parcelable