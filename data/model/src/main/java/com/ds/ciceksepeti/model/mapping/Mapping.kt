package com.ds.ciceksepeti.model.mapping

import com.ds.ciceksepeti.common.extension.orFalse
import com.ds.ciceksepeti.common.extension.orZero
import com.ds.ciceksepeti.model.filter.FilterCategory
import com.ds.ciceksepeti.model.filter.FilterItem
import com.ds.ciceksepeti.model.filter.SelectedFilterItem
import com.ds.ciceksepeti.model.product.DynamicFilter
import com.ds.ciceksepeti.model.product.Value

fun FilterItem.toSelectedFilterItem(): SelectedFilterItem {
    val selectedFilterItem = SelectedFilterItem()
    selectedFilterItem.id = id
    selectedFilterItem.name = name
    selectedFilterItem.group = group
    selectedFilterItem.isMainCategory = isMainCategory
    return selectedFilterItem
}

fun DynamicFilter.toFilterCategory(): FilterCategory {
    val category = FilterCategory()
    category.id = id.orZero()
    category.detailId = detailId
    category.name = name
    category.items = values.toFilterItemList(isMainCategory)
    return category
}

fun Value.toFilterItem(isMainCategory: Boolean? = false): FilterItem {
    val item = FilterItem()
    item.id = id.orZero()
    item.count = count
    item.detailValueId = detailValueId
    item.group = group
    item.icon = icon
    item.name = name
    item.selected = selected.orFalse()
    item.isMainCategory = isMainCategory.orFalse()
    return item
}

fun List<Value>.toFilterItemList(isMainCategory: Boolean? = false): List<FilterItem> {
    return map { it.toFilterItem(isMainCategory) }
}

fun List<DynamicFilter>.toFilterCategoryList(): List<FilterCategory> {
    return map { it.toFilterCategory() }
}