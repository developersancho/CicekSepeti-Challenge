package com.ds.ciceksepeti.challenge

import com.ds.ciceksepeti.challenge.di.appModule
import com.ds.ciceksepeti.common.base.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChallengeApp : BaseApplication() {

    override fun timberLogsEnable(): Boolean {
        return BuildConfig.IsProd.not()
    }

    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() = startKoin {
        androidLogger()
        androidContext(this@ChallengeApp)
        modules(appModule)
    }

}