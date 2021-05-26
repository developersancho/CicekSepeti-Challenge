package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MainFilter(
    @Json(name = "dynamicFilter")
    var dynamicFilter: List<DynamicFilter>?,
    @Json(name = "sort")
    var sort: List<Sort>?
)