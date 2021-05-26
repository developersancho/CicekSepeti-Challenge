package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Price(
    @Json(name = "currency")
    var currency: String?,
    @Json(name = "currencyCode")
    var currencyCode: String?,
    @Json(name = "current")
    var current: Double?,
    @Json(name = "dateBasedDiscountAmount")
    var dateBasedDiscountAmount: Double?,
    @Json(name = "discountPercentage")
    var discountPercentage: Any?,
    @Json(name = "old")
    var old: Double?,
    @Json(name = "oldTotal")
    var oldTotal: Double?,
    @Json(name = "showCurrencyCode")
    var showCurrencyCode: Boolean?,
    @Json(name = "showDecimalPart")
    var showDecimalPart: Boolean?,
    @Json(name = "showDotDecimalPart")
    var showDotDecimalPart: Boolean?,
    @Json(name = "showFirstPrice")
    var showFirstPrice: Boolean?,
    @Json(name = "showRegisterCardButton")
    var showRegisterCardButton: Boolean?,
    @Json(name = "subscriptionDiscountPercentage")
    var subscriptionDiscountPercentage: Any?,
    @Json(name = "subscriptionPrice")
    var subscriptionPrice: Double?,
    @Json(name = "tax")
    var tax: Any?,
    @Json(name = "total")
    var total: Double?
)