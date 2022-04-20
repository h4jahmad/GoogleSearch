package com.wildlearner.ex.googlesearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.wildlearner.ex.googlesearch.databinding.ActivityMainBinding
import com.wildlearner.ex.googlesearch.model.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private val root = binding.root

	private val viewModel: MainViewModel by viewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(root)

		val adapter = ResultListAdapter(object : ItemInteractionListener<Result> {
			override fun onItemClicked(item: Result, position: Int) {
				openUrl(item.link!!)
			}
		})
		binding.activityMainResultRecyclerview.adapter = adapter

		viewModel.searchResultList.observe(this, adapter::setResults)
		viewModel.errorMessage.observe(this) {
			showSnack(root, it)
		}

		viewModel.loading.observe(this) {
			if (it) binding.activityMainProgress.visibility = if (it) View.VISIBLE else View.GONE
		}

		binding.activityMainSearchAction.setOnClickListener {
			val input = binding.activityMainSearchInput.text.toString()
			if (viewModel.isInputValid(input)) viewModel.search(input)
		}

	}

	private fun openUrl(link: String) {
		val intent = with(Intent(Intent.ACTION_VIEW, Uri.parse(link))) {
			addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		}
		startActivity(intent)
	}

}

