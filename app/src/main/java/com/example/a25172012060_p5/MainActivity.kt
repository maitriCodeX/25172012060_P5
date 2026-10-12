package com.example.a25172012060_p5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.a25172012060_p5.ui.navigation.Screen
import com.example.a25172012060_p5.ui.screens.HomeScreen
import com.example.a25172012060_p5.ui.screens.LoginScreen
import com.example.a25172012060_p5.ui.screens.RegisterScreen
import com.example.a25172012060_p5.ui.theme.Practical5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemDark = isSystemInDarkTheme()
            var isDarkTheme by remember { mutableStateOf(systemDark) }

            Practical5Theme(darkTheme = isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Practical5App(
                        isDarkTheme = isDarkTheme,
                        onToggleTheme = { isDarkTheme = !isDarkTheme }
                    )
                }
            }
        }
    }
}

@Composable
fun Practical5App(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }

    when (val screen = currentScreen) {
        is Screen.Login -> {
            LoginScreen(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme,
                onNavigateToRegister = {
                    currentScreen = Screen.Register
                },
                onLoginSuccess = { name, email ->
                    currentScreen = Screen.Home(name = name, email = email)
                }
            )
        }
        is Screen.Register -> {
            BackHandler {
                currentScreen = Screen.Login
            }
            RegisterScreen(
                isDarkTheme = isDarkTheme,
                onToggleTheme = onToggleTheme,
                onNavigateToLogin = {
                    currentScreen = Screen.Login
                },
                onRegisterSuccess = { name, email ->
                    currentScreen = Screen.Home(name = name, email = email)
                }
            )
        }
        is Screen.Home -> {
            BackHandler {
                currentScreen = Screen.Login
            }
            HomeScreen(
                userName = screen.name,
                userEmail = screen.email,
                onLogout = {
                    currentScreen = Screen.Login
                }
            )
        }
    }
}
