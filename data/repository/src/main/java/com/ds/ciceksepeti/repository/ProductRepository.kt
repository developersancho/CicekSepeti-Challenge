package com.ds.ciceksepeti.repository

import com.ds.ciceksepeti.common.repository.BaseRepository
import com.ds.ciceksepeti.common.repository.DataState
import com.ds.ciceksepeti.model.product.ProductResponse
import com.ds.ciceksepeti.remote.service.ProductService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepository(private val service: ProductService) : BaseRepository() {
    fun getProducts(): Flow<DataState<ProductResponse>> = flow {
        emit(apiCall { service.getProducts() })
    }
}