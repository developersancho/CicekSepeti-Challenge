package com.ds.ciceksepeti.common.base

import androidx.viewbinding.ViewBinding
import com.ds.ciceksepeti.common.viewmodel.VMDialog

abstract class BaseViewModelDialog<VB : ViewBinding, VM : BaseViewModel<*>> : VMDialog<VB, VM>() {
}