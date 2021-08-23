package com.visarut.minilotus_task2.view.feature.featureDeliveryHome

import android.util.Log
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.visarut.minilotus_task2.*
import com.visarut.minilotus_task2.domain.epoxy.model.FoodDeliveryData
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData
import kotlin.collections.ArrayList as ArrayList1

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

        val restaurantMap = data?.foodCategoryList?.value?.mapIndexed { index, _ ->
            BannerRestaurantBindingModel_().apply {
                id("res"+index)
            }
        }
        val popularMap = data?.foodCategoryList?.value?.mapIndexed { index, s ->
            PopularBindingModel_().apply {
                id("pop"+index)
            }
        }

        topNavigation {
            id("top_navigation")
        }

        header {
            id("question")
            title("What would you like to order")
            size(32F)

        }

        searchFilter {
            id("search_filter")
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
            size(20F)
        }

        carousel {
            id("featuredRestaurants_carousel")
            restaurantMap?.let {
                models(
                    it
                )
            }
        }

        header {
            id("popular")
            title("Popular items")
            size(20F)
        }

        carousel {
            id("popular_items_carousel")
            popularMap?.let {
                models(
                    it
                )
            }
        }

        }


}