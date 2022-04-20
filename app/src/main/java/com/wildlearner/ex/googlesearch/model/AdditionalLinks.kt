package com.wildlearner.ex.googlesearch.model

import com.google.gson.annotations.SerializedName


data class AdditionalLinks(

	@SerializedName("text") val text: String?,
	@SerializedName("href") val href: String?

)