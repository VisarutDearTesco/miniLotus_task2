package com.visarut.minilotus_task2.view.feature.featureHomeWithEpoxy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.BannersItem
import com.visarut.minilotus_task2.domain.epoxy.DataItem
import com.visarut.minilotus_task2.domain.epoxy.model.FeatureBrandsItem
import kotlinx.coroutines.launch

class Page5ViewModel(val respository : MiniLotusRepository) : ViewModel() {

    val widgetList = MutableLiveData(ArrayList<FeatureBrandsItem>())
    val bannerList =  MutableLiveData(ArrayList<BannersItem>())
    val promotionList = MutableLiveData(ArrayList<BannersItem>())


    init{

        viewModelScope.launch {
            val res = respository.getBanner()
            val res2 = respository.getPromoBanner()
            val logo = respository.getPromoBanner()
            val widget = respository.getWidgetBrand()
//            Log.d("test","widget res : ${widget}")
            widget?.let { saveWidget(it.featureBrands as List<FeatureBrandsItem>?) }
            logo?.let{ saveLogo(it) }
            res?.let { saveBanners(it) }
            res2?.let{ savePromoBanners(it) }
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
//                item.image?.let { LogoBanner(it) }?.let { newArr.add(it) }
                newArr.add(FeatureBrandsItem(item.image,item.url))
            }
        }

        widgetList.value = newArr
    }
}