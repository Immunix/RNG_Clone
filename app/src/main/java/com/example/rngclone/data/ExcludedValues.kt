package com.example.rngclone.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExcludedValues(private val value: Int) : Parcelable