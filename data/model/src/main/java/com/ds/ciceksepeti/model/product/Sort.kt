package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sort(
    @Json(name = "count")
    var count: Int?,
    @Json(name = "detailValueId")
    var detailValueId: Int?,
    @Json(name = "filterQueryString")
    var filterQueryString: Any?,
    @Json(name = "filterQueryStringWithProductGroup")
    var filterQueryStringWithProductGroup: Any?,
    @Json(name = "group")
    var group: Int?,
    @Json(name = "icon")
    var icon: Any?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "link")
    var link: String?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "regionRequired")
    var regionRequired: Boolean?,
    @Json(name = "selected")
    var selected: Boolean?
)