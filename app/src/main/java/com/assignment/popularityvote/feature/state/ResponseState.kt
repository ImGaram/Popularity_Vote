package com.assignment.popularityvote.feature.state

data class ResponseState<T>(
    val isLoading: Boolean = false,
    val response: T? = null
)
