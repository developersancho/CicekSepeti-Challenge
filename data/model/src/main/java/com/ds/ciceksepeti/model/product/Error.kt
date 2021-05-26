package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(
    @Json(name = "message")
    var message: String?,
    @Json(name = "returnUrl")
    var returnUrl: String?,
    @Json(name = "title")
    var title: String?,
    @Json(name = "type")
    var type: Int?
)