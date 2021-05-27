package com.ds.ciceksepeti.model.filter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterItem(
    var id: Int = 0,
    var count: Int? = null,
    var detailValueId: Int? = null,
    var group: Int? = null,
    var icon: String? = null,
    var name: String? = null,
    var selected: Boolean = false,
    var isMainCategory: Boolean = false
): Parcelable