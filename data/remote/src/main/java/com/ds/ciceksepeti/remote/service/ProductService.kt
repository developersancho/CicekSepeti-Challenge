package com.ds.ciceksepeti.remote.service

import com.ds.ciceksepeti.model.product.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductService {

    @GET(PRODUCTS)
    suspend fun getProducts(
        @Query("detailList") detailList: List<Int>,
        @Query("checkList") checkList: List<Int>,
        @Query("priceList") priceList: List<Int>,
    ): ProductResponse

    companion object {
        const val PRODUCTS = "product/ch/dynamicproductlist"
    }
}