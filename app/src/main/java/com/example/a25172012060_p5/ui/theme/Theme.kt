package com.example.a25172012060_p5.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = DarkButtonBg,
    onPrimary = DarkButtonText,
    secondary = GuniPink,
    background = DarkScreenBg,
    surface = DarkCardBg,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = LightButtonBg,
    onPrimary = LightButtonText,
    secondary = GuniPink,
    background = LightScreenBg,
    surface = LightCardBg,
    onBackground = LightInputText,
    onSurface = LightInputText
)

@Composable
fun Practical5Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
