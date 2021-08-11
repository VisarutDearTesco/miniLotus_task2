package com.visarut.minilotus_task2.page5

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.visarut.minilotus_task2.BannerBindingModel_
import com.visarut.minilotus_task2.LogoBindingModel_
import com.visarut.minilotus_task2.banner
import com.visarut.minilotus_task2.epoxy.MiniLotusLisData
import com.visarut.minilotus_task2.header

class EpoxyListController : TypedEpoxyController<MiniLotusLisData>() {

    override fun buildModels(data: MiniLotusLisData?) {

        val widgetMap = data?.widgetList?.value?.mapIndexed{ index, s ->
//            Log.d("test", "index: ${index} , s : ${cast_s.imageUrl}")
            LogoBindingModel_().apply {
                id("logo" + index)
                url(s.image)

            }
        }

        val bannerMap = data?.bannerList?.value?.mapIndexed { index, bannersItem ->
            BannerBindingModel_().apply {
                id("banner" + index)
                bannerUrl(bannersItem.image)
            }
        }

        val promoMap = data?.promotionList?.value?.mapIndexed { index, bannersItem ->
            BannerBindingModel_().apply {
                id("promotion" + index )
                bannerUrl(bannersItem.image)
            }
        }

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

        header {
            id("Banner1")
            title("Banner")
        }

        data?.promotionList?.value?.forEachIndexed { index, bannersItem ->
            banner {
                id("bannerItem" + index )
                bannerUrl(bannersItem.image)
            }
        }

        data?.promotionList?.value?.forEachIndexed { index, bannersItem ->
            banner {
                id("bannerItem" + index )
                bannerUrl(bannersItem.image)
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