package com.ds.ciceksepeti.challenge.di

import com.ds.ciceksepeti.challenge.feature.filter.FilterViewModel
import com.ds.ciceksepeti.challenge.feature.main.MainViewModel
import com.ds.ciceksepeti.challenge.feature.product.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { ProductViewModel(get()) }
    viewModel { FilterViewModel() }
}