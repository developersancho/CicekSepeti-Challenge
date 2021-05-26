package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "error")
    var error: Error?,
    @Json(name = "result")
    var result: Result?
)