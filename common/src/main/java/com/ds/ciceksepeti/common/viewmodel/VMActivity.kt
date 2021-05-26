package com.ds.ciceksepeti.common.viewmodel

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.ds.ciceksepeti.common.binding.BindingActivity
import com.ds.ciceksepeti.common.extension.observeState
import java.lang.ref.WeakReference

abstract class VMActivity<VB : ViewBinding, VM : CoreViewModel> : BindingActivity<VB>() {

    abstract val viewModel: VM

    override fun onViewReady(bundle: Bundle?) {
        viewModel.arguments = intent.extras
        viewModel.fragmentManager = supportFragmentManager
        viewModel.activity = WeakReference(this)
        viewModel.onViewReady(bundle)
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onObserveState() {
        super.onObserveState()
        observeLoadingState()
        observeErrorMessage()
    }

    private fun observeLoadingState() {
        observeState(viewModel.isLoading) { state ->
            state?.let {
                if (it) {
                    showLoading()
                } else {
                    hideLoading()
                }
            }
        }
    }

    private fun observeErrorMessage() {
        observeState(viewModel.errorMessage) { message ->
            message?.let { showErrorMessage(it) }
        }
    }

}