package com.ds.ciceksepeti.challenge.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.ds.ciceksepeti.challenge.feature.main.MainActivity
import com.ds.ciceksepeti.common.extension.fadeInOutTransition
import com.ds.ciceksepeti.common.extension.isOnline
import com.ds.ciceksepeti.common.extension.launchActivity
import com.ds.ciceksepeti.common.widget.DialogUtils
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenCreated {
            if (isOnline()) {
                delay(3000)
                launchActivity<MainActivity> {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                fadeInOutTransition()
            } else {
                DialogUtils.showInternetCheckDialog(this@SplashActivity) {
                    finishAndRemoveTask()
                }
            }
        }
    }
}