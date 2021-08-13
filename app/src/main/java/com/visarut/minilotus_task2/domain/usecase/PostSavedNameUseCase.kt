package com.visarut.minilotus_task2.domain.usecase

import com.visarut.minilotus_task2.data.repository.SharedPrefRepository


class PostSavedNameUseCase (
    val sharedPrefRepository: SharedPrefRepository
) {
    fun invoke(data : String?){
        return sharedPrefRepository.SaveData(data)
    }
}