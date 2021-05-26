package com.ds.ciceksepeti.common.viewmodel

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.ds.ciceksepeti.common.helper.SingleEvent
import com.ds.ciceksepeti.common.repository.DataState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

abstract class CoreViewModel : ViewModel(), InitState, LifecycleState {

    private val _isLoading = MutableLiveData<SingleEvent<Boolean>>()
    val isLoading get() = _isLoading.asFlow()

    private val _errorMessage = MutableLiveData<SingleEvent<String>>()
    val errorMessage get() = _errorMessage.asFlow()

    protected fun showLoading() {
        _isLoading.value = SingleEvent(true)
    }

    protected fun hideLoading() {
        _isLoading.value = SingleEvent(false)
    }

    protected fun showError(message: String) {
        _errorMessage.value = SingleEvent(message)
    }

    protected suspend fun <T> executeState(
        callFlow: Flow<DataState<T>>,
        completionHandler: (data: T) -> Unit
    ) = callFlow
        .onStart { showLoading() }
        .onCompletion { hideLoading() }
        .catch { onError(it) }
        .collect { state ->
            when (state) {
                is DataState.Success -> {
                    completionHandler(state.response)
                }
                is DataState.Error -> {
                    onError(state.error)
                }
            }
        }

    protected suspend fun <T> executeFlow(
        callFlow: Flow<T>,
        completionHandler: (data: T) -> Unit
    ) = callFlow
        .onStart { showLoading() }
        .onCompletion { hideLoading() }
        .catch { onError(it) }
        .collect { state ->
            completionHandler(state)
        }

    open suspend fun onError(throwable: Throwable) {}

    protected fun launchOn(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch { block() }
    }

    override var arguments: Bundle? = null
    override var fragmentManager: FragmentManager? = null
    override var activity: WeakReference<FragmentActivity>? = null

    override fun onViewReady(bundle: Bundle?) {}
    override fun onStart() {}
    override fun onResume() {}
    override fun onPause() {}
    override fun onStop() {}
    override fun onDestroyView() {}
    override fun onDestroy() {}

    protected fun getString(@StringRes resId: Int): String =
        activity?.get()?.getString(resId).orEmpty()

    fun getActivity(): FragmentActivity? = activity?.get()
    fun requireActivity(): FragmentActivity = requireNotNull(activity?.get())
    fun requireFragmentManager(): FragmentManager = requireNotNull(fragmentManager)
    fun requireArgument(): Bundle = requireNotNull(arguments)

}