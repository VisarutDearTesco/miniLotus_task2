package com.visarut.minilotus_task2.data.repository

import com.visarut.minilotus_task2.data.response.FoodCategoryResponse

class FoodDeliveryRepository {

    fun getFoodCategory(): List<FoodCategoryResponse> {

        val foodCategoryList = ArrayList<FoodCategoryResponse>()

        foodCategoryList.add(FoodCategoryResponse("Burger","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Donut","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Pizza","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Mexican","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Mock1","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Mock2","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Mock3","https://picsum.photos/60/60"))
        foodCategoryList.add(FoodCategoryResponse("Mock4","https://picsum.photos/60/60"))

        return foodCategoryList
    }
}