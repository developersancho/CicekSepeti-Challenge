package com.ds.ciceksepeti.challenge.feature.product

import com.ds.ciceksepeti.common.viewmodel.ViewState
import com.ds.ciceksepeti.model.product.DynamicFilter
import com.ds.ciceksepeti.model.product.Product

sealed class ProductViewState : ViewState {
    object Empty : ProductViewState()
    object ProductEmpty: ProductViewState()
    data class ProductList(val list: List<Product>) : ProductViewState()
    data class ProductFilter(val filter: List<DynamicFilter>) : ProductViewState()
}