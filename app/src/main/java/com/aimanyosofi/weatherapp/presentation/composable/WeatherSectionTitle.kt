package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.aimanyosofi.weatherapp.presentation.theme.UrbanistFont
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.theme.WeatherDimens


@Composable
fun WeatherSectionTitle(title: String) {
    Text(
        modifier = Modifier.padding(horizontal = WeatherDimens.mediumPadding),
        text = title,
        fontFamily = UrbanistFont,
        fontSize = 20.sp,
        color = WeatherColors.textColor,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
    )
}