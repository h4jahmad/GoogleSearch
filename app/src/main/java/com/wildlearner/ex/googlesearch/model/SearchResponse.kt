package com.wildlearner.ex.googlesearch.model

import com.google.gson.annotations.SerializedName


data class SearchResponse(
	@SerializedName("results") val results: List<Result>,
	@SerializedName("image_results") val imageResults: List<String>,
	@SerializedName("total") val total: Int?,
	@SerializedName("answers") val answers: List<String>,
	@SerializedName("ts") val ts: Double?,
	@SerializedName("device_region") val deviceRegion: String?,
	@SerializedName("device_type") val deviceType: String?
)