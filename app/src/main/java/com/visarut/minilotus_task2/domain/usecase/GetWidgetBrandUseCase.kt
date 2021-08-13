package com.visarut.minilotus_task2.domain.usecase

import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.model.Data


class GetWidgetBrandUseCase (
    val miniLotusRepository: MiniLotusRepository
        ) {

    suspend fun invoke(): Data? {
        return miniLotusRepository.getWidgetBrand()
    }
}