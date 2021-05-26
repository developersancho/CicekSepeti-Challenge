package com.ds.ciceksepeti.common.binding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BindingFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null

    protected val binding
        get() = _binding
            ?: throw IllegalStateException(
                "Cannot access view in after view destroyed " +
                        "and before view creation"
            )

    protected fun requireBinding(): VB = requireNotNull(_binding)

    protected var viewId: Int = -1

    abstract fun createBinding(): VB

    abstract fun onViewReady(bundle: Bundle?)

    open fun onViewListener() {}

    open fun onObserveState() {}

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = createBinding()
        return binding.root
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewId = binding.root.id
        onObserveState()
        onViewReady(savedInstanceState)
        onViewListener()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    open fun showLoading() {
        (activity as BindingActivity<*>).showLoading()
    }

    open fun hideLoading() {
        (activity as BindingActivity<*>).hideLoading()
    }

    open fun showErrorMessage(message: String) {
        (activity as BindingActivity<*>).showErrorMessage(message)
    }

}