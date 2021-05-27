package com.ds.ciceksepeti.model.filter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterCategory(
    var id: Int = 0,
    var detailId: Int? = null,
    var name: String? = null,
    var items: List<FilterItem> = emptyList()
) : Parcelable