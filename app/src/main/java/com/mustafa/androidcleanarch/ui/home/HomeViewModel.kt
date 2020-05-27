package com.mustafa.androidcleanarch.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.domain.exception.BaseException
import com.mustafa.domain.model.Sample
import com.mustafa.domain.usecase.SampleUseCase

class HomeViewModel(val useCase: SampleUseCase) : ViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
    private val _errors = MutableLiveData<BaseException>()
    val errorLiveData: LiveData<BaseException> = _errors

    private val _sample = MutableLiveData<Sample>()
    val sampleLiveData: LiveData<Sample> = _sample

    fun getSample(name: String) {
        useCase(
            viewModelScope,
            SampleUseCase.Params(name),
            {
                Log.d(TAG, "Successful response")
                _sample.postValue(it)
            },
            {
                Log.d(TAG, "Failure response: ${it.message}")
                _errors.postValue(it)
            }
        )
    }

}