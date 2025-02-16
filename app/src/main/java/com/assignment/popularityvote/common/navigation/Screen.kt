package com.assignment.popularityvote.common.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object LoginScreen: Screen()

    @Serializable
    data object MainScreen: Screen()

    @Serializable
    data class ProfileScreen(val id: Int): Screen()
}