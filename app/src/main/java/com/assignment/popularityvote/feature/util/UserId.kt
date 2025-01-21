package com.assignment.popularityvote.feature.util

object UserId {
    private var userId: String? = null

    fun getInstance(): String? {
        return userId
    }

    fun setUserId(value: String) {
        userId = value
    }
}