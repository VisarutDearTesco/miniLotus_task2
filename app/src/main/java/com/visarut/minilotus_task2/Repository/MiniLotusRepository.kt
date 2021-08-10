package com.visarut.minilotus_task2.Repository

import com.visarut.minilotus_task2.ApiService.ApiService
import com.visarut.minilotus_task2.recycleView.DataItem

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
}