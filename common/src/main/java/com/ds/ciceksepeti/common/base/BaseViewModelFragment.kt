package com.ds.ciceksepeti.common.base

import androidx.viewbinding.ViewBinding
import com.ds.ciceksepeti.common.viewmodel.VMFragment

abstract class BaseViewModelFragment<VB : ViewBinding, VM : BaseViewModel<*>> :
    VMFragment<VB, VM>() {
}