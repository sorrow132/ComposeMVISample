package com.nanemo.composesample.common

sealed class ResponseResult<out T> {
    data class Success<T>(val data: T) : ResponseResult<T>()
    data class Error(val error: Throwable? = null) : ResponseResult<Nothing>()
    object Loading : ResponseResult<Nothing>()
}