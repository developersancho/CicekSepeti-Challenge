package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DynamicFilter(
    @Json(name = "clearLink")
    var clearLink: Any?,
    @Json(name = "detailId")
    var detailId: Int?,
    @Json(name = "dropdownInfo")
    var dropdownInfo: Any?,
    @Json(name = "dropdownTitle")
    var dropdownTitle: Any?,
    @Json(name = "filterBehaviour")
    var filterBehaviour: Int?,
    @Json(name = "filterType")
    var filterType: Int?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "isMainCategory")
    var isMainCategory: Boolean?,
    @Json(name = "isReload")
    var isReload: Boolean?,
    @Json(name = "isRemovableDetail")
    var isRemovableDetail: Boolean?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "sequence")
    var sequence: Int?,
    @Json(name = "urlTag")
    var urlTag: Any?,
    @Json(name = "values")
    var values: List<Value>?
)