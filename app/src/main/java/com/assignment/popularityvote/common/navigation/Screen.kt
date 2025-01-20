package com.assignment.popularityvote.common.navigation

sealed class Screen {
    data object LoginScreen: Screen()
    data object MainScreen: Screen()
    data object ProfileScreen: Screen()
}