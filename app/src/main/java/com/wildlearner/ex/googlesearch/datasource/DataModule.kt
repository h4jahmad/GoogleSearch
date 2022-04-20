package com.wildlearner.ex.googlesearch.datasource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

	@Singleton
	@Binds
	abstract fun bindsMainDataSource(mainRepository: MainRepository): MainDataSource

}