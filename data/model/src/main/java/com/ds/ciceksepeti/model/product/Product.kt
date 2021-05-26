package com.ds.ciceksepeti.model.product


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "adsModel")
    var adsModel: Any?,
    @Json(name = "code")
    var code: String?,
    @Json(name = "dateBasedDiscount")
    var dateBasedDiscount: Any?,
    @Json(name = "deliveryBadgeText")
    var deliveryBadgeText: String?,
    @Json(name = "deliveryBadgeType")
    var deliveryBadgeType: Int?,
    @Json(name = "deliveryChargeMessage")
    var deliveryChargeMessage: Any?,
    @Json(name = "deliveryChargeText")
    var deliveryChargeText: String?,
    @Json(name = "entryId")
    var entryId: Int?,
    @Json(name = "id")
    var id: Int?,
    @Json(name = "image")
    var image: String?,
    @Json(name = "information")
    var information: String?,
    @Json(name = "installment")
    var installment: Boolean?,
    @Json(name = "installmentText")
    var installmentText: String?,
    @Json(name = "isDigital")
    var isDigital: Boolean?,
    @Json(name = "isDiscountAvailable")
    var isDiscountAvailable: Boolean?,
    @Json(name = "isHaveVase")
    var isHaveVase: Boolean?,
    @Json(name = "isHaveVaseText")
    var isHaveVaseText: String?,
    @Json(name = "isMarketplace")
    var isMarketplace: Boolean?,
    @Json(name = "isOriginal")
    var isOriginal: Boolean?,
    @Json(name = "isRequiredLegalPermission")
    var isRequiredLegalPermission: Boolean?,
    @Json(name = "isSubscription")
    var isSubscription: Boolean?,
    @Json(name = "largeImage")
    var largeImage: String?,
    @Json(name = "link")
    var link: String?,
    @Json(name = "marketplaceBranch")
    var marketplaceBranch: Any?,
    @Json(name = "mediumImage")
    var mediumImage: String?,
    @Json(name = "mostSellestProduct")
    var mostSellestProduct: Boolean?,
    @Json(name = "name")
    var name: String?,
    @Json(name = "price")
    var price: Price?,
    @Json(name = "productDeliveryCity")
    var productDeliveryCity: ProductDeliveryCity?,
    @Json(name = "productGroupId")
    var productGroupId: Int?,
    @Json(name = "productType")
    var productType: Int?,
    @Json(name = "responseTimeText")
    var responseTimeText: Any?,
    @Json(name = "reviewCount")
    var reviewCount: Int?,
    @Json(name = "reviewRating")
    var reviewRating: Double?,
    @Json(name = "role")
    var role: Any?,
    @Json(name = "showPriceDroppedTagAtFavoritePage")
    var showPriceDroppedTagAtFavoritePage: Boolean?,
    @Json(name = "smallImage")
    var smallImage: String?,
    @Json(name = "variantCode")
    var variantCode: String?,
    @Json(name = "webLink")
    var webLink: String?,
    @Json(name = "xlargeImage")
    var xlargeImage: String?
)