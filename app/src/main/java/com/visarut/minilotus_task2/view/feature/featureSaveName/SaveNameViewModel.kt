package com.visarut.minilotus_task2.view.feature.featureSaveName

import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.visarut.minilotus_task2.domain.usecase.GetSavedNameUseCase
import com.visarut.minilotus_task2.domain.usecase.PostSavedNameUseCase

class SaveNameViewModel(
    val getSavedNameUseCase: GetSavedNameUseCase,
    val postSavedNameUseCase: PostSavedNameUseCase
) : ViewModel() {

    var name = MutableLiveData<String?>()
    var toastMsg = ""

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
        if(!checkID(savedString.toString())){
            Log.d("test","false")
            return
        }

        return postSavedNameUseCase.invoke(savedString)
    }

    // all int
    // 13 digits
    // check sum
    fun checkID(savedString : String?): Boolean {
        if (savedString?.length != 13 || !isNumber(savedString) || !CheckSum(savedString)){
            toastMsg = "Please check your ID"
            return false
        }
        toastMsg = "Saved Text!"
        return true
    }

    private fun CheckSum(s:String?): Boolean{
        var total = 0
        var mod = 0
        val lastnumber = s?.get(s?.length - 1)?.let { Character.getNumericValue(it) }
        if (s != null) {
            for( i in 0..s.length-2){
                val numberAsIntCorrect = Character.getNumericValue(s[i])
                total += numberAsIntCorrect * (s.length - i)
//                Log.d("test", "i : ${(s.length - i)} | s[i] : ${numberAsIntCorrect}")
            }
        }
        mod = total % 11
        mod = 11 - mod
//        Log.d("test", "total : ${total.toString()} | mod : ${mod.toString()} | lastNum : ${lastnumber}")
        if(lastnumber == mod){
            return true
        }

        return false
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }


}