package com.example.rngclone.ui.excludedNumbers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rngclone.data.ExcludedValues

class ExcludedViewModel : ViewModel() {
    private val excludedNumber: MutableLiveData<List<ExcludedValues>> = MutableLiveData()

    private fun getExcludedNumber(): LiveData<List<ExcludedValues>> {
        return excludedNumber
    }

    fun setExcludedNumber(number: List<ExcludedValues>) {
        excludedNumber.value = number
    }
}