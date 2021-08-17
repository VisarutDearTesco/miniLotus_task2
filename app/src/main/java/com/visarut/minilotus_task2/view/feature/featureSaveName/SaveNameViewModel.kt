package com.visarut.minilotus_task2.view.feature.featureSaveName

import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.visarut.minilotus_task2.domain.usecase.GetSavedNameUseCase
import com.visarut.minilotus_task2.domain.usecase.PostSavedNameUseCase

class SaveNameViewModel(
    val getSavedNameUseCase: GetSavedNameUseCase,
    val postSavedNameUseCase: PostSavedNameUseCase
) : ViewModel() {

    var name = MutableLiveData<String?>()

    init {
        val savedString = getSavedNameUseCase.invoke()
        savedString?.let{
            loadName(it)
        }
    }

    private fun loadName(savedString : String?){
        name.value = savedString
    }

    fun saveName(savedString: Editable){
        Log.d("test","$savedString")
        return postSavedNameUseCase.invoke(savedString)
//        return ""
    }

}