package com.ds.ciceksepeti.common.helper

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.ds.ciceksepeti.common.BuildConfig
import com.ds.ciceksepeti.common.extension.classTag
import com.ds.ciceksepeti.common.extension.debug

class ActivityLifecycleCallback : Application.ActivityLifecycleCallbacks {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        debug(tag = activity.classTag, message = "onCreate()")
        activity.allowDebugRotation()
        activity.registerFragmentLifecycleCallbacks()
    }

    override fun onActivityStarted(activity: Activity) {
        debug(tag = activity.classTag, message = "onStart()")
    }

    override fun onActivityResumed(activity: Activity) {
        debug(tag = activity.classTag, message = "onResume()")
    }

    override fun onActivityPaused(activity: Activity) {
        debug(tag = activity.classTag, message = "onPause()")
    }

    override fun onActivityStopped(activity: Activity) {
        debug(tag = activity.classTag, message = "onStop()")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        debug(tag = activity.classTag, message = "onSaveInstanceState()")
    }

    override fun onActivityDestroyed(activity: Activity) {
        debug(tag = activity.classTag, message = "onDestroy()")
    }
}

private fun Activity.allowDebugRotation() {
    requestedOrientation = if (BuildConfig.IsProd.not()) {
        ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    } else {
        ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}

fun Activity.registerFragmentLifecycleCallbacks() {
    if (this is FragmentActivity) {
        supportFragmentManager
            .registerFragmentLifecycleCallbacks(object :
                FragmentManager.FragmentLifecycleCallbacks() {

                override fun onFragmentViewCreated(
                    fm: FragmentManager,
                    f: Fragment,
                    v: View,
                    savedInstanceState: Bundle?
                ) {
                    super.onFragmentViewCreated(fm, f, v, savedInstanceState)
                    debug(tag = f.classTag, message = "onCreateView()")
                }

                override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
                    super.onFragmentStarted(fm, f)
                    debug(tag = f.classTag, message = "onStart()")
                }

                override fun onFragmentResumed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentResumed(fm, f)
                    debug(tag = f.classTag, message = "onResume()")
                }

                override fun onFragmentPaused(fm: FragmentManager, f: Fragment) {
                    super.onFragmentPaused(fm, f)
                    debug(tag = f.classTag, message = "onPause()")
                }

                override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
                    super.onFragmentStopped(fm, f)
                    debug(tag = f.classTag, message = "onStop()")
                }

                override fun onFragmentViewDestroyed(fm: FragmentManager, f: Fragment) {
                    super.onFragmentViewDestroyed(fm, f)
                    debug(tag = f.classTag, message = "onDestroyView()")
                }
            }, true)
    }
}