package com.visarut.minilotus_task2.ApiService

import com.visarut.minilotus_task2.model.WidgetResponse
import com.visarut.minilotus_task2.recycleView.BannerResponse
import retrofit2.http.GET
import retrofit2.http.Header


interface ApiService {

    @GET("/oneapp-mobile-bff/banner/v1/banners?bannerType=TOP_BANNER_HOME_PAGE")
    suspend fun fetchAllBanner(@Header("key") key : String,@Header("Accept-Language") AcceptLanguage : String  ): BannerResponse

    @GET("/oneapp-mobile-bff/banner/v1/banners?bannerType=BRAND_PROMOTION_BANNER")
    suspend fun fetchPromoBanner(@Header("key") key : String,@Header("Accept-Language") AcceptLanguage : String  ): BannerResponse

    @GET("/oneapp-mobile-bff/widget/v1/brands")
    suspend fun fetchWidgetBrand(@Header("key") key : String,@Header("Accept-Language") AcceptLanguage : String  ): WidgetResponse
}

