package com.ds.ciceksepeti.repository.di

import com.ds.ciceksepeti.repository.ProductRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { ProductRepository(get()) }
}