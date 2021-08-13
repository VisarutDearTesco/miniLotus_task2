package com.visarut.minilotus_task2.domain.epoxy.model

import androidx.lifecycle.MutableLiveData

data class SharedPrefData(
    var name: MutableLiveData<String?>
    )