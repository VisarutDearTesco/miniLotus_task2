package com.visarut.minilotus_task2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.ApiService.ApiService
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.model.DataItem
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Page1fragmentViewModel(val respository : MiniLotusRepository) : ViewModel() {

    val promotionList = MutableLiveData(ArrayList<PromotionItem>())

    init{

        viewModelScope.launch {
            val res = respository.getBanner()
            res?.let { saveBanners(it) }

        }

    }

    private fun saveBanners(banners: List<DataItem?>){

        val newArr = ArrayList<PromotionItem>()

        for (item in banners) {
            item?.banners!!.forEach {
//                promotionList.add(PromotionItem(it?.image.toString(), it?.url.toString()))
                  newArr.add(PromotionItem(it?.image.toString(), it?.url.toString()))
            }
        }
        promotionList.value = newArr

    }

}

