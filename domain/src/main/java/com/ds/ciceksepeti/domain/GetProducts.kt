package com.ds.ciceksepeti.domain

import com.ds.ciceksepeti.common.repository.DataState
import com.ds.ciceksepeti.common.usecase.FlowDataStateUseCase
import com.ds.ciceksepeti.model.product.ProductResponse
import com.ds.ciceksepeti.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProducts(private val repository: ProductRepository) :
    FlowDataStateUseCase<GetProducts.Param, ProductResponse>() {

    data class Param(
        var detailList: List<Int> = listOf(),
        var checkList: List<Int> = listOf(),
        var priceList: List<Int> = listOf()
    )

    override fun execute(params: Param): Flow<DataState<ProductResponse>> {
        return repository.getProducts(params.detailList, params.checkList, params.priceList)
    }
}