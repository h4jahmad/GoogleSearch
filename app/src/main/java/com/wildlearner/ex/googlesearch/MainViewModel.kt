package com.wildlearner.ex.googlesearch

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wildlearner.ex.googlesearch.datasource.MainDataSource
import com.wildlearner.ex.googlesearch.model.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.EmptyCoroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(private val mainDataSource: MainDataSource) : ViewModel() {

	val errorMessage = MutableLiveData<String>()
	val searchResultList = MutableLiveData<List<Results>>()
	val loading = MutableLiveData<Boolean>()
//	var job: Job? = null

	val exceptionHandler = CoroutineExceptionHandler { _, t ->
		onError("Exception: ${t.localizedMessage}")
	}

	fun search(query: String) {
		viewModelScope.launch(context = EmptyCoroutineContext + exceptionHandler) {
			val response = mainDataSource.search(query)
			withContext(Dispatchers.Main) {
				if (response.isSuccessful) {
					searchResultList.postValue(response.body()?.results)
					loading.value = false
				} else {
					onError("Error: ${response.message()}")
				}
			}
		}
	}

	private fun onError(message: String) {
		errorMessage.value = message
		loading.value = false
	}

	fun isInputValid(input: String): Boolean = !TextUtils.isEmpty(input)

}
