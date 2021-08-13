package com.visarut.minilotus_task2.domain.usecase

import android.content.Context
import android.content.SharedPreferences
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.data.repository.SharedPrefRepository
import com.visarut.minilotus_task2.domain.epoxy.model.Data


class GetSavedNameUseCase (
    val sharedPrefRepository: SharedPrefRepository
) {

    fun invoke(): String? {
        return sharedPrefRepository.loadData()
    }

}