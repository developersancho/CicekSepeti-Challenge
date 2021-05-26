package com.ds.ciceksepeti.common.repository

sealed class DataState<out T> {
    data class Success<out T>(val response: T) : DataState<T>()
    data class Error(val error: Throwable) : DataState<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$response]"
            is Error -> "Error[exception=$error]"
        }
    }
}

val DataState<*>.onSuccess get() = this is DataState.Success && response != null

fun <T> DataState<T>.onSuccessOr(fallback: T): T {
    return (this as? DataState.Success<T>)?.response ?: fallback
}