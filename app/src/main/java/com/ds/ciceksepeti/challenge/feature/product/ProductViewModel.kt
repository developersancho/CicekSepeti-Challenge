package com.ds.ciceksepeti.challenge.feature.product

import com.ds.ciceksepeti.common.base.BaseViewModel
import com.ds.ciceksepeti.common.extension.orZero
import com.ds.ciceksepeti.domain.GetProducts
import com.ds.ciceksepeti.model.filter.SelectedFilterItem
import com.ds.ciceksepeti.model.product.DynamicFilter

class ProductViewModel(private val getProducts: GetProducts) : BaseViewModel<ProductViewState>() {

    fun getProductList(selectedFilters: ArrayList<SelectedFilterItem>) = launchOn {
        val detailList = arrayListOf<Int>()
        val checkList = arrayListOf<Int>()
        val priceList = arrayListOf<Int>()
        selectedFilters.filter { it.group == 1 }.forEach { detailList.add(it.id) }
        selectedFilters.filter { it.group == 2 }.forEach { checkList.add(it.id) }
        selectedFilters.filter { it.group == 3 }.forEach { priceList.add(it.id) }

        val param = GetProducts.Param()
        param.detailList = detailList
        param.checkList = checkList
        param.priceList = priceList

        executeState(getProducts.invoke(param)) {
            if (it.error?.type.orZero() == 0) {
                val products = it.result?.data?.products.orEmpty()
                val dynamicFilters = it.result?.data?.mainFilter?.dynamicFilter.orEmpty()

                if (products.isNotEmpty()) {
                    setState(ProductViewState.ProductList(products))
                } else {
                    setState(ProductViewState.ProductEmpty)
                }

                setState(ProductViewState.ProductFilter(dynamicFilters))
            } else {
                showError(it.error?.message.toString())
            }
        }
    }

}