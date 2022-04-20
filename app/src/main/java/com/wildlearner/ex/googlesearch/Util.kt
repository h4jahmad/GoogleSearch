package com.wildlearner.ex.googlesearch

import android.view.View
import com.google.android.material.snackbar.Snackbar


fun showSnack(root: View, message: String) {
	Snackbar.make(root, message, Snackbar.LENGTH_LONG).show()
}