package com.ds.ciceksepeti.remote

import android.os.Build
import com.ds.ciceksepeti.remote.service.ProductService
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.inject
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ProductServiceTest : BaseServiceTest() {

    private val service by inject<ProductService>()

    @Test
    fun getProducts() = runBlocking {
        val detailList = listOf(2007217)
        val checkList = listOf(2007124)
        val priceList = listOf(1, 2, 3)
        val response = service.getProducts(detailList, checkList, priceList)
        println(response.result?.data?.products?.firstOrNull()?.name)
        println(response.result?.data?.products?.firstOrNull()?.installmentText)
        Assert.assertEquals(2787616, response.result?.data?.products?.firstOrNull()?.id)
    }


    @Test
    fun getProductsNoFilters() = runBlocking {
        val detailList = listOf<Int>()
        val checkList = listOf<Int>()
        val priceList = listOf<Int>()
        val response = service.getProducts(detailList, checkList, priceList)
        println(response.result?.data?.products?.firstOrNull()?.name)
        println(response.result?.data?.products?.firstOrNull()?.installmentText)
        Assert.assertEquals(2787616, response.result?.data?.products?.firstOrNull()?.id)
    }

}