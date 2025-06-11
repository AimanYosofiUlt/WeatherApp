package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
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
import com.aimanyosofi.weatherapp.presentation.util.WeatherResourceUtil
import com.aimanyosofi.weatherapp.presentation.view_model.state.CurrentForecast

@Composable
fun CurrentWeatherDetails(
    currentTemperature: CurrentForecast,
    modifier: Modifier = Modifier,
) {
    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = modifier,
            text = "${currentTemperature.temperature}°C",
            fontFamily = UrbanistFont,
            fontSize = 64.sp,
            color = WeatherColors.textColor,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        Text(
            modifier = Modifier,
            text = WeatherResourceUtil.getName(currentTemperature.weatherCode),
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        VerticalSpace(12.dp)

        CurrentTemperature(currentTemperature)
    }
}

@Composable
private fun CurrentTemperature(currentTemperature: CurrentForecast) {
    Row(
        modifier = Modifier
            .background(WeatherColors.textColor.copy(alpha = 0.08f), RoundedCornerShape(100.dp))
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.arrow_top_04),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(WeatherColors.textColor.copy(alpha = 0.6f))
        )

        HorizontalSpace(4.dp)

        Text(
            modifier = Modifier,
            text = "${currentTemperature.higherTemperature}°C",
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        HorizontalSpace(8.dp)
        Spacer(
            modifier = Modifier
                .background(WeatherColors.textColor.copy(alpha = 0.24f))
                .height(15.dp)
                .width(1.dp)
        )
        HorizontalSpace(8.dp)

        Image(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.arrow_down_04),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            colorFilter = ColorFilter.tint(WeatherColors.textColor.copy(alpha = 0.6f))
        )

        HorizontalSpace(4.dp)

        Text(
            modifier = Modifier,
            text = "${currentTemperature.lowerTemperature}°C",
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )
    }
}