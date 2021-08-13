package com.visarut.minilotus_task2.domain.usecase

import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.DataItem


class GetBannerUseCase (
    val miniLotusRepository: MiniLotusRepository
) {

    suspend fun invoke(): List<DataItem?>? {
        return miniLotusRepository.getBanner()
    }
}