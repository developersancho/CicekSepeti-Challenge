package com.ds.ciceksepeti.challenge.di

import com.ds.ciceksepeti.challenge.BuildConfig
import com.ds.ciceksepeti.domain.di.domainModule
import com.ds.ciceksepeti.remote.di.remoteModule
import com.ds.ciceksepeti.repository.di.repositoryModule

val appModule = listOf(
    remoteModule(baseUrl = BuildConfig.BASE_URL, BuildConfig.IsProd.not()),
    repositoryModule,
    domainModule,
    viewModelModule
)