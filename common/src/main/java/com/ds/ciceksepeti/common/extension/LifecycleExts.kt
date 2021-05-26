package com.ds.ciceksepeti.common.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.ds.ciceksepeti.common.helper.SingleEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.observeState(property: Flow<SingleEvent<T>>, block: (T?) -> Unit) {
    lifecycleScope.launch {
        property.collect {
            block(it.getContentIfNotHandled())
        }
    }
}