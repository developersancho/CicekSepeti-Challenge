package com.ds.ciceksepeti.common.base

import androidx.viewbinding.ViewBinding
import com.ds.ciceksepeti.common.extension.toast
import com.ds.ciceksepeti.common.viewmodel.VMActivity
import com.ds.ciceksepeti.common.widget.LoadingDialog

abstract class BaseViewModelActivity<VB : ViewBinding, VM : BaseViewModel<*>> : VMActivity<VB, VM>() {

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

    override fun showErrorMessage(message: String) {
        super.showErrorMessage(message)
        toast(message)
    }

}