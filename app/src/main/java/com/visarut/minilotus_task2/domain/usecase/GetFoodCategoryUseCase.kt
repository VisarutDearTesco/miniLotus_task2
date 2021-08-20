package com.visarut.minilotus_task2.domain.usecase

import com.visarut.minilotus_task2.data.repository.FoodDeliveryRepository
import com.visarut.minilotus_task2.data.response.FoodCategoryResponse


class GetFoodCategoryUseCase(
    val foodDeliveryRepository: FoodDeliveryRepository
) {
    fun invoke(): List<FoodCategoryResponse> {
        return foodDeliveryRepository.getFoodCategory()
    }
}