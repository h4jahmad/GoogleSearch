package com.wildlearner.ex.googlesearch.datasource

import com.wildlearner.ex.googlesearch.model.SearchResponse
import com.wildlearner.ex.googlesearch.network.GoogleService
import retrofit2.Response
import javax.inject.Inject

class MainRepository(@Inject val service: GoogleService) : MainDataSource {

	override suspend fun search(query: String): Response<SearchResponse> = service.search(query)


}