package com.ds.ciceksepeti.challenge.feature.filter

import com.ds.ciceksepeti.common.base.BaseViewModel
import com.ds.ciceksepeti.common.extension.isNotNull
import com.ds.ciceksepeti.model.filter.FilterCategory
import com.ds.ciceksepeti.model.filter.FilterItem
import com.ds.ciceksepeti.model.filter.SelectedFilterItem
import com.ds.ciceksepeti.model.mapping.toSelectedFilterItem
import com.ds.ciceksepeti.model.product.DynamicFilter

class FilterViewModel : BaseViewModel<FilterViewState>() {

    // todo: group field selectedDetailList(1), selectedCheckList(2), selectedPriceList(3) ArrayList<FilterItem>
    var selectedFilters = arrayListOf<SelectedFilterItem>()
    private var selectedFiltersId = arrayListOf<Int>()
    private var dynamicFilterList = listOf<FilterCategory>()


    fun setFilter(filter: FilterItem) {
        val selectedFilterItem = filter.toSelectedFilterItem()
        if (selectedFiltersId.contains(selectedFilterItem.id)) {
            removeFilterId(selectedFilterItem.id)
            removeFilter(selectedFilterItem)
        } else {
            if (selectedFilterItem.isMainCategory) {
                val selectedFilterMainCategory = selectedFilters.find { it.isMainCategory }
                if (selectedFilterMainCategory.isNotNull()) {
                    removeFilterId(selectedFilterMainCategory!!.id)
                    removeFilter(selectedFilterMainCategory)
                }
            }
            addFilterId(selectedFilterItem.id)
            addFilter(selectedFilterItem)
        }
    }

    fun addFilter(filter: SelectedFilterItem) {
        selectedFilters.add(filter)
    }

    fun removeFilter(filter: SelectedFilterItem) {
        selectedFilters.remove(filter)
    }

    fun clearFilter() {
        selectedFilters.clear()
    }

    fun addFilterId(filterId: Int) {
        selectedFiltersId.add(filterId)
    }

    fun removeFilterId(filterId: Int) {
        selectedFiltersId.remove(filterId)
    }

    fun clearFilterId() {
        selectedFiltersId.clear()
    }

    fun clear() {
        clearFilter()
        clearFilterId()
    }

    /**
     * filtreleme parametleri bir kez alınıyor...
     */
    fun setFilterCategory(categoryList: List<FilterCategory>) {
        if (dynamicFilterList.isEmpty()) {
            dynamicFilterList = categoryList
        }

        if (selectedFilters.isEmpty()) {
            setState(FilterViewState.Category(dynamicFilterList))
        } else {
            dynamicFilterList.map { cat ->
                cat.items.map { item ->
                    item.selected = selectedFilters.find { it.id == item.id } != null
                }
            }
            setState(FilterViewState.Category(dynamicFilterList))
        }
    }

    fun clearCategoryItems(filterCategory: FilterCategory?) {
        val categoryItems = filterCategory?.items
        categoryItems.orEmpty().forEach {
            removeFilterId(it.id)
            removeFilter(it.toSelectedFilterItem())
        }
    }

}