package com.ds.ciceksepeti.domain

import android.os.Build
import androidx.test.platform.app.InstrumentationRegistry
import com.ds.ciceksepeti.domain.di.domainModule
import com.ds.ciceksepeti.remote.di.remoteModule
import com.ds.ciceksepeti.repository.di.repositoryModule
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
open class BaseDomainTest : KoinTest {

    private val appContext = InstrumentationRegistry.getInstrumentation().targetContext
    private val baseUrl = BuildConfig.BASE_URL


    @Before
    open fun setUp() {
        configureDi()
    }

    @After
    open fun tearDown() {
        stopKoin()
    }

    private fun configureDi() {
        startKoin {
            androidContext(appContext)
            loadKoinModules(
                listOf(
                    remoteModule(baseUrl, true),
                    repositoryModule,
                    domainModule
                )
            )
        }
    }

}