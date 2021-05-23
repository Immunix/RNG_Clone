package com.example.rngclone.ui.rng

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RngViewModel : ViewModel() {
    private val _minNumber: MutableLiveData<String> = MutableLiveData("1")
    private val _maxNumber: MutableLiveData<String> = MutableLiveData("100")
    private val _maxIterations: MutableLiveData<String> = MutableLiveData("1")
    private val _resultsList: MutableLiveData<List<String>> = MutableLiveData()

    fun getMin(): LiveData<String> {
        return _minNumber
    }
    fun getMax(): LiveData<String> {
        return _maxNumber
    }
    fun getIterations(): LiveData<String> {
        return _maxIterations
    }
    fun getResults(): LiveData<List<String>> {
        return _resultsList
    }
    fun setResults(list: List<String>) {
        _resultsList.value = list
    }
}