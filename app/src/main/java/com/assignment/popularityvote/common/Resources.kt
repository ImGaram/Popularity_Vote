package com.assignment.popularityvote.common

sealed class Resources<T>(
    val data: T? = null
) {
    class Success<T>(data: T?): Resources<T>(data)
    class Error<T>(data: T? = null): Resources<T>(data)
    class Loading<T>(val isLoading: Boolean = true): Resources<T>(null)
}