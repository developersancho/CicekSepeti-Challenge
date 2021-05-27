package com.ds.ciceksepeti.challenge.feature.filter

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.ciceksepeti.challenge.databinding.FragmentFilterBinding
import com.ds.ciceksepeti.challenge.feature.filter.item.FilterItemDialog
import com.ds.ciceksepeti.common.base.BaseViewModelFragment
import com.ds.ciceksepeti.common.extension.observeState
import com.ds.ciceksepeti.common.extension.toast
import com.ds.ciceksepeti.model.filter.FilterCategory
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FilterFragment : BaseViewModelFragment<FragmentFilterBinding, FilterViewModel>() {

    private val adapter by lazy { FilterAdapter() }

    override val viewModel: FilterViewModel by sharedViewModel()

    override fun createBinding(): FragmentFilterBinding {
        return FragmentFilterBinding.inflate(layoutInflater)
    }

    override fun onViewReady(bundle: Bundle?) {
        super.onViewReady(bundle)
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvFilterCategory.setHasFixedSize(true)
        binding.rvFilterCategory.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        binding.rvFilterCategory.layoutManager = layoutManager
        adapter.onItemClicked = {
            showFilterItemDialog(it)
        }
    }

    private fun showFilterItemDialog(it: FilterCategory) {
        val dialog = FilterItemDialog.show(childFragmentManager, it)
        dialog.filterDone = {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onViewListener() {
        super.onViewListener()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        binding.tvClear.setOnClickListener {
            adapter.clearData()
            viewModel.clear()
        }

        binding.btnShowResult.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onObserveState() {
        super.onObserveState()
        observeState(viewModel.viewState) { state ->
            when (state) {
                null -> Unit
                is FilterViewState.Empty -> Unit
                is FilterViewState.Category -> {
                    adapter.categoryItems = state.categories
                }
            }
        }
    }

}