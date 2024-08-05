package com.sojourn.domain.trip

sealed class Resource<T>(
    private val _data: T? = null,
    private val _error: Throwable? = null
) {
    class Loading<T> : Resource<T>(_data = null, _error = null)

    data class Error<T>(val throwable: Throwable) : Resource<T>(_error = throwable)

    data class Success<T>(val data: T) : Resource<T>(_data = data)
}