package com.ds.ciceksepeti.challenge.feature.filter.item

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ds.ciceksepeti.challenge.databinding.RowItemFilterSelectedBinding
import com.ds.ciceksepeti.challenge.feature.filter.FilterViewModel
import com.ds.ciceksepeti.common.binding.toBinding
import com.ds.ciceksepeti.common.extension.gone
import com.ds.ciceksepeti.common.extension.visible
import com.ds.ciceksepeti.model.filter.FilterItem

class FilterItemAdapter(private val vm: FilterViewModel) :
    RecyclerView.Adapter<FilterItemAdapter.FilterItemViewHolder>() {
    private var lastSelectedPos: Int = -1

    private var items = listOf<FilterItem>()

    fun setData(data: List<FilterItem>) {
        items = data
        notifyDataSetChanged()
    }

    fun clearData() {
        lastSelectedPos = -1
        items.map { it.selected = false }
        notifyDataSetChanged()
    }

    inner class FilterItemViewHolder(private val binding: RowItemFilterSelectedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FilterItem) {
            binding.tvFilterName.text = item.name

            if (item.selected) {
                binding.llSelectedArea.visible()
            } else {
                binding.llSelectedArea.gone()
            }

            if (item.isMainCategory) {
                if (item.selected) {
                    lastSelectedPos = adapterPosition
                }
            }

            binding.root.setOnClickListener {
                configureFilter(item)
            }
        }

        /**
         * Ana kategori ise listeden tek seçim yapılır.
         * @param lastSelectedPos
         */
        private fun configureFilter(item: FilterItem) {
            if (item.isMainCategory) {
                if (lastSelectedPos != -1) {
                    items[lastSelectedPos].selected = false
                }
            }
            item.selected = item.selected.not()
            lastSelectedPos = adapterPosition

            notifyDataSetChanged()
            vm.setFilter(item)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemViewHolder {
        return FilterItemViewHolder(parent.toBinding())
    }

    override fun onBindViewHolder(holder: FilterItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

}