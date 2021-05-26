package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductData(
    @Json(name = "backgroundColor")
    var backgroundColor: Any?,
    @Json(name = "banners")
    var banners: Any?,
    @Json(name = "branch")
    var branch: Any?,
    @Json(name = "categoryName")
    var categoryName: Any?,
    @Json(name = "filter")
    var filter: Any?,
    @Json(name = "hasOldPrice")
    var hasOldPrice: Boolean?,
    @Json(name = "isAlternate")
    var isAlternate: Boolean?,
    @Json(name = "mainFilter")
    var mainFilter: MainFilter?,
    @Json(name = "message")
    var message: Any?,
    @Json(name = "productCount")
    var productCount: Int?,
    @Json(name = "products")
    var products: List<Product>?,
    @Json(name = "storeId")
    var storeId: Any?,
    @Json(name = "subCategoryModel")
    var subCategoryModel: SubCategoryModel?,
    @Json(name = "title")
    var title: Any?
)