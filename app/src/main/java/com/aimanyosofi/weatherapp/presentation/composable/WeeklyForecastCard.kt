package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.presentation.theme.UrbanistFont
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast

@Composable
fun WeeklyForecastCard(modifier: Modifier = Modifier,weekForecast: WeekForecast) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            modifier = Modifier,
            text = weekForecast.dayName,
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        Image(
            modifier = Modifier
                .weight(1f)
                .height(45.dp),
            painter = painterResource(id = weekForecast.iconRes),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Image(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.arrow_top_04),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Text(
            modifier = Modifier,
            text = "${weekForecast.higherTemperature}°C",
            fontFamily = UrbanistFont,
            fontSize = 14.sp,
            color = WeatherColors.textColor.copy(alpha = 0.87f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        Image(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.arrow_down_04),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )

        Text(
            modifier = Modifier,
            text = "${weekForecast.lowerTemperature}°C",
            fontFamily = UrbanistFont,
            fontSize = 14.sp,
            color = WeatherColors.textColor.copy(alpha = 0.87f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )
    }
}