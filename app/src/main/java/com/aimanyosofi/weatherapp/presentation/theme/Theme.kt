package com.aimanyosofi.weatherapp.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable
fun WeatherAppTheme(
    colors: WeatherAppColors,
    dimens: WeatherAppDimens = WeatherAppDimens(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalAppDimens provides dimens
    ) {
        content()
    }
}