package com.ds.ciceksepeti.common.extension

import android.app.Activity
import com.ds.ciceksepeti.common.R

fun Activity.fadeInOutTransition() {
    overridePendingTransition(R.anim.fade_in, R.anim.splash_fade_out)
}