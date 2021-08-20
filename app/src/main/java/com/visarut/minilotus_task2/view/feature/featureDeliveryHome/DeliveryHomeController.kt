package com.visarut.minilotus_task2.view.feature.featureDeliveryHome

import android.util.Log
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.visarut.minilotus_task2.FoodcategoryBindingModel_
import com.visarut.minilotus_task2.domain.epoxy.model.FoodDeliveryData
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData
import com.visarut.minilotus_task2.header

class DeliveryHomeController() : TypedEpoxyController<FoodDeliveryData>() {

    override fun buildModels(data: FoodDeliveryData?) {



        val foodMap = data?.foodCategoryList?.value?.mapIndexed{ index, s ->
            Log.d("test","index")
            FoodcategoryBindingModel_().apply {
                id("food"+index)
                foodUrl(s.imageUrl)
                title(s.categoryName)
            }
        }


        carousel {
            id("food_carousel")
            foodMap?.let{
                models(
                    it
                )
            }
        }

        header {
            id("featureRestaurants")
            title("Featured restaurants")
        }


        }


}