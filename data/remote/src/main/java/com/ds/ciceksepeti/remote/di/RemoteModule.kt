package com.ds.ciceksepeti.remote.di

import com.ds.ciceksepeti.remote.service.ProductService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

fun remoteModule(baseUrl: String, isDebug: Boolean = true) = module {

    single<Moshi>(named("moshi")) { Moshi.Builder().build() }

    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .followSslRedirects(true)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (isDebug)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(get(named("moshi"))))
            .build()
    }

    factory { get<Retrofit>().create(ProductService::class.java) }
}