package com.ds.ciceksepeti.common.base

import com.ds.ciceksepeti.common.viewmodel.StateViewModel
import com.ds.ciceksepeti.common.viewmodel.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException

abstract class BaseViewModel<VS : ViewState> : StateViewModel<VS>(), KoinComponent {

    // todo: create message key-value in strings.xml
    override suspend fun onError(throwable: Throwable) = withContext(Dispatchers.Main) {
        when (throwable) {
            // case no internet connection
            is UnknownHostException -> {
                showError(message = "No Internet Connection")
            }
            is ConnectException -> {
                showError(message = "ConnectException")
            }
            // case request time out
            is SocketTimeoutException -> {
                showError(message = "Request Time Out SocketTimeoutException")
            }
            is IOException -> {
                showError(message = "IO Exception")
            }
            is HttpException -> {
                val code = throwable.code()
                val errorResponse = throwable.response()
                showError(message = "${code}-${errorResponse}")
            }
            is UnknownServiceException -> {
                showError(message = "UnknownServiceException")
            }
        }
    }
}