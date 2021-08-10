package com.visarut.minilotus_task2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.visarut.minilotus_task2.Repository.MiniLotusRepository
import com.visarut.minilotus_task2.recycleView.DataItem
import com.visarut.minilotus_task2.recycleView.PromotionTypeImage
import com.visarut.minilotus_task2.recycleView.PromotionTypeText
import com.visarut.minilotus_task2.recycleView.RecycleViewBaseItem
import kotlinx.coroutines.launch

class TestViewBindingViewModel(val repository: MiniLotusRepository) : ViewModel() {

    val promotionList = MutableLiveData<List<String>?>()

    init {
        viewModelScope.launch {
            var result = repository.getBanner()
            saveBanners(result)
        }
    }

    private fun saveBanners(banners: List<DataItem?>?) {

        banners?.let {

            val newArr = ArrayList<String>()

            for (item in banners) {
                item?.banners!!.forEach {
                    newArr.add(it?.image.toString())
                }
            }
            promotionList.value = newArr
        }

    }

    var numberLiveData: MutableLiveData<Int> = MutableLiveData(0)

    fun updateNumber() {
        numberLiveData.value = numberLiveData.value?.plus(1)
        Log.d("test", "${numberLiveData.value}")
    }


}