package com.aimanyosofi.weatherapp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class WeatherAppDimens(
    val extraSmallPadding: Dp = 4.dp,
    val smallPadding: Dp = 8.dp,
    val mediumPadding: Dp = 12.dp,
    val largePadding: Dp = 16.dp,
    val extraLargePadding: Dp = 24.dp
)

val LocalAppDimens = staticCompositionLocalOf { WeatherAppDimens() }

inline val WeatherDimens: WeatherAppDimens @ReadOnlyComposable @Composable get() = LocalAppDimens.current
