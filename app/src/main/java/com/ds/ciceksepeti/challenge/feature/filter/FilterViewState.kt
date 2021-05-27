package com.ds.ciceksepeti.challenge.feature.filter

import com.ds.ciceksepeti.common.viewmodel.ViewState
import com.ds.ciceksepeti.model.filter.FilterCategory

sealed class FilterViewState : ViewState {
    object Empty: FilterViewState()
    data class Category(val categories: List<FilterCategory>) : FilterViewState()
}
