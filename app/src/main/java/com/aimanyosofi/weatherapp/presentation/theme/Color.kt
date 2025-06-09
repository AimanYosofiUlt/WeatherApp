package com.aimanyosofi.weatherapp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFF87CEFA)
val BlackColor = Color(0xFF060414)
val WhiteColor = Color(0xFFFFFFFF)

data class WeatherAppColors(
    val textColor: Color,
    val primaryColor: Color,
    val backgroundColor: Color,
    val whiteToBlack: Color,
    val primaryToBlack: Color,
)

val weatherAppLightColors = WeatherAppColors(
    textColor = BlackColor,
    primaryColor = PrimaryColor,
    backgroundColor = WhiteColor,
    whiteToBlack = WhiteColor,
    primaryToBlack = PrimaryColor,
)

val WeatherAppDarkColors = WeatherAppColors(
    textColor = WhiteColor,
    primaryColor = PrimaryColor,
    backgroundColor = BlackColor,
    whiteToBlack = BlackColor,
    primaryToBlack = BlackColor,
)

val LocalColors = staticCompositionLocalOf<WeatherAppColors> {
    error("No CustomColors provided")
}

inline val WeatherColors: WeatherAppColors @ReadOnlyComposable @Composable get() = LocalColors.current