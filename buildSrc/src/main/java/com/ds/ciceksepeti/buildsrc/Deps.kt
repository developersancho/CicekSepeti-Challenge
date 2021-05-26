package com.ds.ciceksepeti.buildsrc

object Deps {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"

    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit2}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val conscrypt = "org.conscrypt:conscrypt-android:${Versions.conscrypt}"
    const val retrofitUrl = "me.jessyan:retrofit-url-manager:${Versions.jessyan}"

    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtx}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtx}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}"
    const val java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleKtx}"
    const val process = "androidx.lifecycle:lifecycle-process:${Versions.lifecycleKtx}"

    const val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navDynamic =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    const val prefStoreMoshi =
        "com.github.developersancho.prefstore:prefstore-moshi:${Versions.prefstore}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val koinCore = "io.insert-koin:koin-core:${Versions.koin}"
    const val koinAndroid = "io.insert-koin:koin-android:${Versions.koin}"
    const val koinExt = "io.insert-koin:koin-android-ext:${Versions.koin}"
    const val koinWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.koin}"


    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockwebserver}"
    const val mockito2 = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitokotlin2}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
    const val koinTest = "io.insert-koin:koin-test:${Versions.koin}"
    const val koinJunit4 = "io.insert-koin:koin-test-junit4:${Versions.koin}"
    const val koinJunit5 = "io.insert-koin:koin-test-junit5:${Versions.koin}"
    const val annotationTest = "androidx.annotation:annotation:${Versions.annotation}"
}