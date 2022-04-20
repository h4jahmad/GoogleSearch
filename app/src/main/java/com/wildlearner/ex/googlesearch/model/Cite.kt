package com.wildlearner.ex.googlesearch.model

import com.google.gson.annotations.SerializedName


data class Cite(

	@SerializedName("domain") val domain: String?,
	@SerializedName("span") val span: String?

)