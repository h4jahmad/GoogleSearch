package com.wildlearner.ex.googlesearch.datasource

import com.wildlearner.ex.googlesearch.model.SearchResponse
import retrofit2.Response

interface MainDataSource {
	suspend fun search(query: String): Response<SearchResponse>
}