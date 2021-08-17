package com.visarut.minilotus_task2.data.repository

import android.content.SharedPreferences
import android.text.Editable

class SharedPrefRepository(
    val sharedPref : SharedPreferences
) {

    fun loadData() : String? {
        val savedString = sharedPref?.getString("STRING_KEY",null)
        return savedString
    }

    fun SaveData(data: Editable){
        val editor = sharedPref?.edit()

        editor?.apply {
            putString("STRING_KEY", data.toString())
        }?.apply()

    }
}