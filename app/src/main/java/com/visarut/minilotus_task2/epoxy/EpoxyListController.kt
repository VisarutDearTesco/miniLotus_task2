package com.visarut.minilotus_task2.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.visarut.minilotus_task2.LogoBannerBindingModel_
import com.visarut.minilotus_task2.headerPromotion
import com.visarut.minilotus_task2.logoBanner

class EpoxyListController : TypedEpoxyController<MiniLotusListData>() {

    override fun buildModels(data: MiniLotusListData?) {

        val map = data?.bannerList?.mapIndexed { index, s ->
            LogoBannerBindingModel_().apply {
                id("logo" + index)
                url(s)
            }
        }

        headerPromotion {
            id("1")
            title("test")
        }
        carousel {
            id("carousel")
            map?.let {
                models(
                    it
                )
            }

        }

        headerPromotion {
            id("2")
            title("test")
        }
        headerPromotion {
            id("3")
            title("test")
        }
        headerPromotion {
            id("4")
            title("test")
        }

    }
}