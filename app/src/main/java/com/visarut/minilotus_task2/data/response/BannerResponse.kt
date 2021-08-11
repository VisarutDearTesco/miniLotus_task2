package com.visarut.minilotus_task2.domain.epoxy

import com.google.gson.annotations.SerializedName

data class BannerResponse(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class DataItem(

	@field:SerializedName("template")
	val template: String? = null,

	@field:SerializedName("displayDuration")
	val displayDuration: Int? = null,

	@field:SerializedName("banners")
	val banners: List<BannersItem?>? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class BannersItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
