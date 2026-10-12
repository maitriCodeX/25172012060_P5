package com.example.a25172012060_p5.ui.navigation

sealed interface Screen {
    object Login : Screen
    object Register : Screen
    data class Home(val name: String, val email: String) : Screen
}
