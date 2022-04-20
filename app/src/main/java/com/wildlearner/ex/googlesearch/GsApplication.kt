package com.wildlearner.ex.googlesearch

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GsApplication: MultiDexApplication() {

	override fun attachBaseContext(base: Context?) {
		super.attachBaseContext(base)
		MultiDex.install(base)
	}
	companion object {
		val TAG: String = GsApplication::class.java.simpleName
	}

	override fun onCreate() {
		super.onCreate()

		Log.i(TAG, "onCreate: Application started.")

	}
}
