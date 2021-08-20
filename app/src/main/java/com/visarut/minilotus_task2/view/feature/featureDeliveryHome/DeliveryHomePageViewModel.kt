package com.visarut.minilotus_task2.view.feature.featureDeliveryHome

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.visarut.minilotus_task2.data.response.FoodCategoryResponse
import com.visarut.minilotus_task2.domain.usecase.GetFoodCategoryUseCase

class DeliveryHomePageViewModel(
    val getFoodCategory : GetFoodCategoryUseCase
) : ViewModel() {
    val foodCategoryList = MutableLiveData(ArrayList<FoodCategoryResponse>())

    init {
        val foodCategory = getFoodCategory.invoke()
        foodCategory?.let {
            saveFoodCategory(it)
        }
    }

    private fun saveFoodCategory(foodCategory : List<FoodCategoryResponse>){
        val newArr = ArrayList<FoodCategoryResponse>()

        for(item in foodCategory){
            newArr.add(FoodCategoryResponse(item.categoryName,item.imageUrl))
        }

        foodCategoryList.value = newArr
    }

}