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
        val response = service.getProducts()
        println(response.result?.data?.products?.firstOrNull()?.name)
        println(response.result?.data?.products?.firstOrNull()?.installmentText)
        Assert.assertEquals(2787616, response.result?.data?.products?.firstOrNull()?.id)
    }

}