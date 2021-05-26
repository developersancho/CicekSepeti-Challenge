package com.ds.ciceksepeti.remote.service

import com.ds.ciceksepeti.model.product.ProductResponse
import retrofit2.http.GET

interface ProductService {

    @GET(PRODUCTS)
    suspend fun getProducts(): ProductResponse

    companion object {
        const val PRODUCTS = "product/ch/dynamicproductlist"
    }
}