package com.ds.ciceksepeti.challenge.feature.product

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ds.ciceksepeti.challenge.databinding.FragmentProductBinding
import com.ds.ciceksepeti.challenge.feature.filter.FilterViewModel
import com.ds.ciceksepeti.common.base.BaseViewModelFragment
import com.ds.ciceksepeti.common.extension.gone
import com.ds.ciceksepeti.common.extension.observeState
import com.ds.ciceksepeti.common.extension.visible
import com.ds.ciceksepeti.model.mapping.toFilterCategoryList
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseViewModelFragment<FragmentProductBinding, ProductViewModel>() {

    private val adapter by lazy { ProductAdapter() }

    private val filterViewModel by sharedViewModel<FilterViewModel>()

    override val viewModel: ProductViewModel by viewModel()

    override fun createBinding(): FragmentProductBinding {
        return FragmentProductBinding.inflate(layoutInflater)
    }

    override fun onViewReady(bundle: Bundle?) {
        super.onViewReady(bundle)
        initAdapter()
        viewModel.getProductList(filterViewModel.selectedFilters)
    }

    private fun initAdapter() {
        binding.rvProduct.setHasFixedSize(true)
        binding.rvProduct.adapter = adapter
        val layoutManager = LinearLayoutManager(context)
        binding.rvProduct.layoutManager = layoutManager
    }

    override fun onViewListener() {
        super.onViewListener()
        binding.ivFilter.setOnClickListener {
            val frFilter = ProductFragmentDirections.actionProductFragmentToFilterFragment()
            findNavController().navigate(frFilter)
        }
    }

    override fun onObserveState() {
        super.onObserveState()
        observeState(viewModel.viewState) { state ->
            when (state) {
                null -> Unit
                is ProductViewState.Empty -> Unit
                is ProductViewState.ProductList -> {
                    binding.clEmpty.gone()
                    adapter.items = state.list
                }
                is ProductViewState.ProductFilter -> {
                    filterViewModel.setFilterCategory(state.filter.toFilterCategoryList())
                }
                is ProductViewState.ProductEmpty -> {
                    binding.clEmpty.visible()
                }
            }
        }
    }

}