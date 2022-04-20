package com.wildlearner.ex.googlesearch.network

interface ApiResponse {
	fun loading()
	fun onFailure(e: Throwable)
	fun <T>onSuccess(result: T)
	fun empty()
}