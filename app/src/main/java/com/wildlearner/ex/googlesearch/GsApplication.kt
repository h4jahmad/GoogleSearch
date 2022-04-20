package com.wildlearner.ex.googlesearch

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GsApplication: Application() {
	companion object {
		val TAG: String = GsApplication::class.java.simpleName
	}

	override fun onCreate() {
		super.onCreate()
		Log.i(TAG, "onCreate: Application started.")

	}
}
