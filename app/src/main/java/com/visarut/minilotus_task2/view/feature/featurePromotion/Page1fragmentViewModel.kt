package com.visarut.minilotus_task2.view.feature.featurePromotion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.*
import com.visarut.minilotus_task2.domain.epoxy.model.*
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.LayoutSubItem
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.LogoBanner
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.PromotionTypeImage
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.PromotionTypeText
import kotlinx.coroutines.launch

class Page1fragmentViewModel(val respository : MiniLotusRepository) : ViewModel() {

    val promotionList = MutableLiveData(ArrayList<RecycleViewBaseItem>())

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

        val newArr = ArrayList<RecycleViewBaseItem>()

        newArr.add(PromotionTypeText("Banners"))
        for (item in banners) {
            item?.banners!!.forEach {
                newArr.add(PromotionTypeImage(it?.image.toString()))
            }
        }
        promotionList.value = newArr

    }
    private fun savePromoBanners(banners: List<DataItem?>){

        val newArr = ArrayList<RecycleViewBaseItem>()

        newArr.add(PromotionTypeText("Promotion Banners"))
        for (item in banners) {
            item?.banners!!.forEach {
                newArr.add(PromotionTypeImage(it?.image.toString()))
            }
        }
        promotionList.value = newArr

    }

    private fun saveLogo(banners: List<DataItem?>){

        val newArr = ArrayList<RecycleViewBaseItem>()
        val subArr = ArrayList<RecycleViewBaseItem>()
        for (item in banners) {
            item?.banners!!.forEach {
//                newArr.add(LogoBanner(it?.image.toString()))
                subArr.add(LogoBanner(it?.image.toString()))
            }
        }
        newArr.add(PromotionTypeText("Brand"))
        newArr.add(LayoutSubItem(subArr))
        Log.d("test", "${subArr.toString()}")

        promotionList.value = newArr

    }

    private fun saveWidget(widgets : List<FeatureBrandsItem>?) {
        val newArr = ArrayList<RecycleViewBaseItem>()
        if (widgets != null) {
            for (item in widgets) {
                item.image?.let { LogoBanner(it) }?.let { newArr.add(it) }
            }
        }

        promotionList.value = newArr
    }

}

