package com.ds.ciceksepeti.challenge.feature.filter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ds.ciceksepeti.challenge.databinding.RowItemFilterBinding
import com.ds.ciceksepeti.common.binding.toBinding
import com.ds.ciceksepeti.common.extension.gone
import com.ds.ciceksepeti.common.extension.visible
import com.ds.ciceksepeti.model.filter.FilterCategory

class FilterAdapter : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    var onItemClicked: ((FilterCategory) -> Unit)? = null

    var categoryItems: List<FilterCategory> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun clearData() {
        categoryItems.map { it.items.map { item -> item.selected = false } }
        notifyDataSetChanged()
    }

    inner class FilterViewHolder(private val binding: RowItemFilterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FilterCategory) {
            binding.tvCategoryName.text = item.name
            val selectedItem = getSelectedItem(item)
            if (selectedItem.isNotEmpty()) {
                binding.tvFilterItem.visible()
                binding.tvFilterItem.text = selectedItem
            } else {
                binding.tvFilterItem.gone()
                binding.tvFilterItem.text = ""
            }
            binding.root.setOnClickListener {
                onItemClicked?.invoke(item)
            }
        }

        private fun getSelectedItem(item: FilterCategory): String {
            val list = item.items.filter { it.selected }
            var names = ""
            if (list.size == 1)
                return list.first().name.toString()

            list.forEach {
                names += "${it.name.toString()}, "
            }
            return names
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(parent.toBinding())
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(categoryItems[position])
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

}