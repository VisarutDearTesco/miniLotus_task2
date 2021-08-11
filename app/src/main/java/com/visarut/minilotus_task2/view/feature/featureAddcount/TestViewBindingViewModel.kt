package com.visarut.minilotus_task2.view.feature.featureAddcount

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewBindingViewModel : ViewModel() {


    var numberLiveData: MutableLiveData<Int> = MutableLiveData(0)

    fun updateNumber() {
        numberLiveData.value = numberLiveData.value?.plus(1)
        Log.d("test","${numberLiveData.value}")
    }

}