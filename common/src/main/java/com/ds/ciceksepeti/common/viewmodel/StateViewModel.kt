package com.ds.ciceksepeti.common.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.ds.ciceksepeti.common.helper.SingleEvent

abstract class StateViewModel<VS : ViewState> : CoreViewModel() {

    private val _state = MutableLiveData<SingleEvent<VS>>()
    val viewState = _state.asFlow()

    protected fun setState(state: VS) {
        _state.value = SingleEvent(state)
    }


}