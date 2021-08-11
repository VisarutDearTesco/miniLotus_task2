package com.visarut.minilotus_task2.view.feature.featureBanner

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.data.repository.MiniLotusRepository
import com.visarut.minilotus_task2.domain.epoxy.DataItem
import com.visarut.minilotus_task2.domain.epoxy.model.baseitem.LogoBanner
import com.visarut.minilotus_task2.domain.epoxy.RecycleViewBaseItem
import kotlinx.coroutines.launch

class Page2ViewModel(val miniLotusRepository: MiniLotusRepository) : ViewModel() {
    val promotionList = MutableLiveData(ArrayList<RecycleViewBaseItem>())
//    var miniLotusRepository : MiniLotusRepository = MiniLotusRepository()

    init{
        viewModelScope.launch {
            val res = miniLotusRepository.getPromoBanner()
            res?.let { saveBanners(it) }
        }
    }

    private fun saveBanners(banners: List<DataItem?>){

        val newArr = ArrayList<RecycleViewBaseItem>()

        for (item in banners) {
            item?.banners!!.forEach {
//                promotionList.add(PromotionItem(it?.image.toString(), it?.url.toString()))
                newArr.add(LogoBanner(it?.image.toString()))
            }
        }
        promotionList.value = newArr

    }

}