package com.ds.ciceksepeti.common.viewmodel

import android.os.Bundle

interface LifecycleState {

    fun onViewReady(bundle: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroyView()

    fun onDestroy()

}