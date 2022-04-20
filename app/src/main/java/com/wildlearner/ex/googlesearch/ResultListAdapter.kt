package com.wildlearner.ex.googlesearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wildlearner.ex.googlesearch.databinding.ActivityMainResultItemBinding
import com.wildlearner.ex.googlesearch.model.Result

class ResultListAdapter(private val listener: ItemInteractionListener<Result>) :
	RecyclerView.Adapter<ResultListAdapter.ItemViewHolder>() {

	private var resultList = mutableListOf<Result>()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
		ItemViewHolder(
			ActivityMainResultItemBinding.inflate(LayoutInflater.from(parent.context),
				parent,
				false), listener)


	override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
		holder.bind(getItem(position), position)
	}

	override fun getItemCount(): Int = resultList.size

	fun setResults(results: List<Result>) {
		resultList = results.toMutableList()
		notifyDataSetChanged()
	}

	private fun getItem(position: Int): Result = resultList[position]

	class ItemViewHolder(
		private val binding: ActivityMainResultItemBinding,
		private val listener: ItemInteractionListener<Result>,
	) :
		RecyclerView.ViewHolder(binding.root) {
		fun bind(item: Result, position: Int) {
			binding.activityMainResultItemRoot.setOnClickListener {
				listener.onItemClicked(item, position)
			}
			binding.activityMainResultItemUrl.text = item.link.toString()
			binding.activityMainResultItemTitle.text = item.title.toString()
			binding.activityMainResultItemDescription.text = item.description.toString()
		}
	}

}