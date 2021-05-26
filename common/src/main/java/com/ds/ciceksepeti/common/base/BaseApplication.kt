package com.ds.ciceksepeti.common.base

import android.app.Application
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.ds.ciceksepeti.common.helper.ActivityLifecycleCallback
import timber.log.Timber

open class BaseApplication : Application(), LifecycleObserver {
    var isAppInForeground: Boolean = true

    open fun timberLogsEnable(): Boolean = true

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        registerActivityLifecycleCallbacks(ActivityLifecycleCallback())
        if (timberLogsEnable()) {
            Timber.plant(Timber.DebugTree())
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        //App in background
        isAppInForeground = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        //App in foreground
        isAppInForeground = true
    }


}