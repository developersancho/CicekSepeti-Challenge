package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDeliveryCity(
    @Json(name = "deliveryCityImage")
    var deliveryCityImage: String?,
    @Json(name = "isSendToSingleCity")
    var isSendToSingleCity: Boolean?
)