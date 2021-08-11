package com.visarut.minilotus_task2.Data.repository

import com.visarut.minilotus_task2.Data.repository.ApiService.ApiService
import com.visarut.minilotus_task2.Domain.epoxy.model.Data
import com.visarut.minilotus_task2.Domain.epoxy.DataItem

class MiniLotusRepository(val api : ApiService) {

    val apikey = "cL1wvTEJcL3d6UFdZQUk4WlR1XC84S1N"
    val acceptLang = "th"

    suspend fun getBanner() : List<DataItem?>? {
        val res = api.fetchAllBanner(apikey,acceptLang)
        return res.data
    }

    suspend fun getPromoBanner(): List<DataItem?>? {
        val res = api.fetchPromoBanner(apikey,acceptLang)
        return res.data
    }

    suspend fun getWidgetBrand(): Data? {
        val res = api.fetchWidgetBrand(apikey,acceptLang)
//        Log.d("test","widget : ${res.data}")
        return res.data
    }

}