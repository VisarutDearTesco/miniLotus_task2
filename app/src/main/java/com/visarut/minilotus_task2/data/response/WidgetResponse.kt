package com.visarut.minilotus_task2.domain.epoxy.model

import com.google.gson.annotations.SerializedName

data class WidgetResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class Data(

	@field:SerializedName("seeAllText")
	val seeAllText: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("featureBrands")
	val featureBrands: List<FeatureBrandsItem?>? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class FeatureBrandsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
