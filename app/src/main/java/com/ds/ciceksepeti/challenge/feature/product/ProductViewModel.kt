package com.ds.ciceksepeti.challenge.feature.product

import android.os.Bundle
import com.ds.ciceksepeti.common.base.BaseViewModel
import com.ds.ciceksepeti.common.extension.orZero
import com.ds.ciceksepeti.domain.GetProducts

class ProductViewModel(private val getProducts: GetProducts) : BaseViewModel<ProductViewState>() {

    override fun onViewReady(bundle: Bundle?) {
        super.onViewReady(bundle)
        getProductList()
    }

    private fun getProductList() = launchOn {
        executeState(getProducts.invoke(Unit)) {
            if (it.error?.type.orZero() == 0) {
                setState(ProductViewState.ProductList(it.result?.data?.products.orEmpty()))
            } else {
                showError(it.error?.message.toString())
            }
        }
    }

}