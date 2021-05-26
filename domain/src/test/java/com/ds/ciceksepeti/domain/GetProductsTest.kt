package com.ds.ciceksepeti.domain

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
class GetProductsTest : BaseDomainTest() {

    private val getProducts by inject<GetProducts>()

    @Test
    fun getProducts() = runBlocking {
        getProducts.invoke(Unit).collect { state ->
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