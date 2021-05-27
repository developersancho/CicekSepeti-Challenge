package com.ds.ciceksepeti.model.filter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectedFilterItem(
    var id: Int = 0,
    var group: Int? = null,
    var name: String? = null,
    var isMainCategory: Boolean = false
): Parcelable