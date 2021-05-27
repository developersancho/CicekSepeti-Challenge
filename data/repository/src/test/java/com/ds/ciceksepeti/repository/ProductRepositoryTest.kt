package com.ds.ciceksepeti.repository

import android.os.Build
import com.ds.ciceksepeti.common.repository.DataState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.inject
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ProductRepositoryTest : BaseRepositoryTest() {

    private val repo by inject<ProductRepository>()

    @Test
    fun getProducts() = runBlocking {
        val detailList = listOf(2007217)
        val checkList = listOf(2007124)
        val priceList = listOf(1, 2, 3)
        repo.getProducts(detailList, checkList, priceList).collect { state ->
            when (state) {
                is DataState.Error -> {
                    println(state.error.message)
                }
                is DataState.Success -> {
                    println(state.response.result?.data?.products?.firstOrNull()?.name)
                    println(state.response.result?.data?.products?.firstOrNull()?.installmentText)
                    Assert.assertEquals(
                        2787616,
                        state.response.result?.data?.products?.firstOrNull()?.id
                    )
                }
            }
        }
    }


}