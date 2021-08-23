package com.visarut.minilotus_task2.domain.epoxy.model

import androidx.lifecycle.MutableLiveData
import com.visarut.minilotus_task2.data.response.FoodCategoryResponse

data class FoodDeliveryData(
    var foodCategoryList : MutableLiveData<ArrayList<FoodCategoryResponse>>?,
    var featuredRestaurantList : MutableLiveData<ArrayList<FoodCategoryResponse>>?
)
