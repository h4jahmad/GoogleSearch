package com.wildlearner.ex.googlesearch

@FunctionalInterface
interface ItemInteractionListener<T> {
	fun onItemClicked(item: T, position: Int)
}