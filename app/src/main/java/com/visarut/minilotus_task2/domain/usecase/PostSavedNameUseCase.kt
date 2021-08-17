package com.visarut.minilotus_task2.domain.usecase

import android.text.Editable
import com.visarut.minilotus_task2.data.repository.SharedPrefRepository


class PostSavedNameUseCase (
    val sharedPrefRepository: SharedPrefRepository
) {
    fun invoke(data: Editable){
        return sharedPrefRepository.SaveData(data)
    }
}