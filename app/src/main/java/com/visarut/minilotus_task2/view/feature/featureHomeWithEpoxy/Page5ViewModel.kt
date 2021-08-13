package com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.BannersItem
import com.visarut.minilotus_task2.domain.epoxy.DataItem
import com.visarut.minilotus_task2.domain.epoxy.model.FeatureBrandsItem
import com.visarut.minilotus_task2.domain.usecase.GetBannerUseCase
import com.visarut.minilotus_task2.domain.usecase.GetPromoBannerUseCase
import com.visarut.minilotus_task2.domain.usecase.GetWidgetBrandUseCase
import kotlinx.coroutines.launch

class Page5ViewModel(
    val getWidgetBrandUseCase : GetWidgetBrandUseCase,
    val getBannerUseCase: GetBannerUseCase,
    val getPromoBannerUseCase: GetPromoBannerUseCase
) : ViewModel() {

    val widgetList = MutableLiveData(ArrayList<FeatureBrandsItem>())
    val bannerList =  MutableLiveData(ArrayList<BannersItem>())
    val promotionList = MutableLiveData(ArrayList<BannersItem>())


    init{

        viewModelScope.launch {
            val widget = getWidgetBrandUseCase.invoke()
            val banner = getBannerUseCase.invoke()
            val promoBanner = getPromoBannerUseCase.invoke()
            widget?.let { saveWidget(it.featureBrands as List<FeatureBrandsItem>?) }
            banner?.let { saveBanners(it) }
            promoBanner?.let{ savePromoBanners(it) }
        }

    }

    private fun saveBanners(banners: List<DataItem?>){

        val newArr = ArrayList<BannersItem>()

        for (item in banners) {
            item?.banners!!.forEach {
                newArr.add(BannersItem(it?.image.toString()))
            }
        }
        bannerList.value = newArr

    }
    private fun savePromoBanners(banners: List<DataItem?>){

        val newArr = ArrayList<BannersItem>()

        for (item in banners) {
            item?.banners!!.forEach {
                newArr.add(BannersItem(it?.image.toString()))
            }
        }
        promotionList.value = newArr

    }

    private fun saveLogo(banners: List<DataItem?>){

        val newArr = ArrayList<BannersItem>()
        for (item in banners) {
            item?.banners!!.forEach {
                newArr.add(BannersItem(it?.image.toString()))
//                subArr.add(LogoBanner(it?.image.toString()))
            }
        }
//        Log.d("test", "${subArr.toString()}")

        promotionList.value = newArr

    }

    private fun saveWidget(widgets : List<FeatureBrandsItem>?) {
        val newArr = ArrayList<FeatureBrandsItem>()
        if (widgets != null) {
            for (item in widgets) {
                newArr.add(FeatureBrandsItem(item.image,item.url))
            }
        }

        widgetList.value = newArr
    }
}