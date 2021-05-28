package com.ds.ciceksepeti.challenge.feature.product

import com.ds.ciceksepeti.common.base.BaseViewModel
import com.ds.ciceksepeti.common.constants.CHECK_LIST
import com.ds.ciceksepeti.common.constants.DETAIL_LIST
import com.ds.ciceksepeti.common.constants.PRICE_LIST
import com.ds.ciceksepeti.common.constants.SERVICE_TYPE_SUCCESS
import com.ds.ciceksepeti.common.extension.orZero
import com.ds.ciceksepeti.domain.GetProducts
import com.ds.ciceksepeti.model.filter.SelectedFilterItem

class ProductViewModel(private val getProducts: GetProducts) : BaseViewModel<ProductViewState>() {

    fun getProductList(selectedFilters: ArrayList<SelectedFilterItem>) = launchOn {
        val detailList = arrayListOf<Int>()
        val checkList = arrayListOf<Int>()
        val priceList = arrayListOf<Int>()
        selectedFilters.filter { it.group == DETAIL_LIST }.forEach { detailList.add(it.id) }
        selectedFilters.filter { it.group == CHECK_LIST }.forEach { checkList.add(it.id) }
        selectedFilters.filter { it.group == PRICE_LIST }.forEach { priceList.add(it.id) }

        val param = GetProducts.Param()
        param.detailList = detailList
        param.checkList = checkList
        param.priceList = priceList

        executeState(getProducts.invoke(param)) {
            if (it.error?.type.orZero() == SERVICE_TYPE_SUCCESS) {
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