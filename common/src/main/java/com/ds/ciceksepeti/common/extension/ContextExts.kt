package com.ds.ciceksepeti.common.extension

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

@SuppressLint("MissingPermission")
fun Context.isOnline(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    val netInfo = cm?.activeNetworkInfo
    return netInfo != null && netInfo.isConnected
}