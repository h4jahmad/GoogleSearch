package com.wildlearner.ex.googlesearch.network

import com.wildlearner.ex.googlesearch.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

const val API_URL = "https://google-search3.p.rapidapi.com"

interface GoogleService {

	@GET("/api/v1/search/")
	suspend fun search(@Path("q") query: String): Response<SearchResponse>
}