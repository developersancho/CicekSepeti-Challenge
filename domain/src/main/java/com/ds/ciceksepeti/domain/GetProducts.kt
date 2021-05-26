package com.ds.ciceksepeti.domain

import com.ds.ciceksepeti.common.repository.DataState
import com.ds.ciceksepeti.common.usecase.FlowDataStateUseCase
import com.ds.ciceksepeti.model.product.ProductResponse
import com.ds.ciceksepeti.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class GetProducts(private val repository: ProductRepository) :
    FlowDataStateUseCase<Unit, ProductResponse>() {

    override fun execute(params: Unit): Flow<DataState<ProductResponse>> {
        return repository.getProducts()
    }
}