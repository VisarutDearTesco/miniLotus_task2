package com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.visarut.minilotus_task2.*
import com.visarut.minilotus_task2.domain.epoxy.model.MiniLotusListData

class EpoxyListController() : TypedEpoxyController<MiniLotusListData>() {

    private var callback: EpoxyListController.AddOnItemSelected? = null

    interface AddOnItemSelected {
        fun onClickBanner(url : String?)
        fun onClickLogo()
    }

    fun setItemSelectListener(callback : AddOnItemSelected){
        this.callback = callback
    }


    override fun buildModels(data: MiniLotusListData?) {

        val widgetMap = data?.widgetList?.value?.mapIndexed{ index, s ->
//            Log.d("test", "index: ${index} , s : ${cast_s.imageUrl}")
            LogoBindingModel_().apply {
                id("logo" + index)
                url(s.image)

            }
        }

//        val foodMap = data?.widgetList?.value?.mapIndexed{ index, _ ->
//            FoodcategoryBindingModel_().apply {
//                id("food"+index)
//            }
//        }




        header {
            id("Brand1")
            title("Brand")

        }

        carousel {
            id("Brand_carousel")
            widgetMap?.let{
                models(
                    it
                )
            }
        }

//        carousel {
//            id("food_carousel")
//            foodMap?.let{
//                models(
//                    it
//                )
//            }
//        }



        header {
            id("Banner1")
            title("Banner")
        }


        data?.promotionList?.value?.forEachIndexed { index, bannersItem ->
            banner {
                id("bannerItem" + index )
                bannerUrl(bannersItem.image)
                onClickBannerItem { _ ->
                    this@EpoxyListController.callback?.onClickBanner(bannersItem.image)
                }
            }
        }

        header {
            id("Promotion1")
            title("Promotion")
        }

        data?.promotionList?.value?.forEachIndexed { index, bannersItem ->
            banner {
                id("bannerItem" + index )
                bannerUrl(bannersItem.image)
            }
        }



    }

}
