package com.ds.ciceksepeti.domain.di

import com.ds.ciceksepeti.domain.GetProducts
import org.koin.dsl.module

val domainModule = module {
    single { GetProducts(get()) }
}