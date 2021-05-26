package com.ds.ciceksepeti.model.product


import com.ds.ciceksepeti.model.product.ProductData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "data")
    var data: ProductData?
)