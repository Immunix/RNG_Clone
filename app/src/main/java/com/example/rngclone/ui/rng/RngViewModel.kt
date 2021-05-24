package com.example.rngclone.ui.rng

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RngViewModel : ViewModel() {
    private val _minNumber: MutableLiveData<String> = MutableLiveData("1")
    private val _maxNumber: MutableLiveData<String> = MutableLiveData("100")
    private val _maxIterations: MutableLiveData<String> = MutableLiveData("1")
    private val _resultsList: MutableLiveData<List<Int>> = MutableLiveData()

    fun getMin(): LiveData<String> {
        return _minNumber
    }

    fun getMax(): LiveData<String> {
        return _maxNumber
    }

    fun getIterations(): LiveData<String> {
        return _maxIterations
    }

    fun getResults(): LiveData<List<Int>> {
        return _resultsList
    }

    fun setResults(list: List<Int>) {
        _resultsList.value = list
    }

    fun setMin(min: String) {
        _minNumber.value = min
    }

    fun setMax(max: String) {
        _maxNumber.value = max
    }

    fun setIterations(iterations: String) {
        _maxIterations.value = iterations
    }
}