package com.visarut.minilotus_task2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.recycleView.*
import kotlinx.coroutines.launch

class Page1fragmentViewModel(val respository : MiniLotusRepository) : ViewModel() {

    val promotionList = MutableLiveData(ArrayList<RecycleViewBaseItem>())

    init{

        viewModelScope.launch {
            val res = respository.getBanner()
            val res2 = respository.getPromoBanner()
            val logo = respository.getPromoBanner()
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

}

