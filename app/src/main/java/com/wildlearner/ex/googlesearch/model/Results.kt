package com.wildlearner.ex.googlesearch.model

import com.google.gson.annotations.SerializedName


data class Results(

	@SerializedName("title") val title: String?,
	@SerializedName("link") val link: String?,
	@SerializedName("description") val description: String?,
	@SerializedName("additional_links") val additionalLinks: List<AdditionalLinks>,
	@SerializedName("cite") val cite: Cite?

)