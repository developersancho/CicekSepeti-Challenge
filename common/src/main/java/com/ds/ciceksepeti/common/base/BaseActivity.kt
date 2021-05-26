package com.ds.ciceksepeti.common.base

import androidx.viewbinding.ViewBinding
import com.ds.ciceksepeti.common.binding.BindingActivity
import com.ds.ciceksepeti.common.widget.LoadingDialog

abstract class BaseActivity<VB : ViewBinding> : BindingActivity<VB>() {

    private var loadingDialog: LoadingDialog? = null

    override fun showLoading() {
        super.showLoading()
        if (loadingDialog == null) {
            loadingDialog = LoadingDialog(this)
        }
        loadingDialog?.show()
    }

    override fun hideLoading() {
        super.hideLoading()
        loadingDialog?.dismiss()
    }
}