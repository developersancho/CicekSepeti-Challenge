package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SubCategoryModel(
    @Json(name = "shapeType")
    var shapeType: Int?,
    @Json(name = "subCategoryList")
    var subCategoryList: List<Any>?
)