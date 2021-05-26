package com.ds.ciceksepeti.common.binding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BindingActivity<VB : ViewBinding> : AppCompatActivity() {

    lateinit var binding: VB

    abstract fun createBinding(): VB

    abstract fun onViewReady(bundle: Bundle?)

    open fun onViewListener() {}

    open fun onObserveState() {}

    open fun showLoading() {}

    open fun hideLoading() {}

    open fun showErrorMessage(message: String) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::binding.isInitialized.not()) {
            binding = createBinding()
            setContentView(binding.root)
        }
        onObserveState()
        onViewReady(savedInstanceState)
        onViewListener()
    }

}