package com.wildlearner.ex.googlesearch.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object RetrofitProvider {

	private const val TIMEOUT: Long = 30

	@Singleton
	@Provides
	fun provideRetrofit(): GoogleService {
		return Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(API_URL)
			.client(provideOkHttpClient(provideHttpLoggingInterceptor()))
			.build().create(GoogleService::class.java)
	}


	private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
		return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
	}

	private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
		val httpClient = OkHttpClient.Builder()
			.addInterceptor(loggingInterceptor)
			.readTimeout(TIMEOUT, TimeUnit.SECONDS)
			.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
			.addInterceptor {
				val authorisedRequest = it.request().newBuilder()
					.addHeader("Content-Type", "application/json")
					.build()
				it.proceed(authorisedRequest)
			}
		return httpClient.build()
	}
}