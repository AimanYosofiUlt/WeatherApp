package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.presentation.theme.UrbanistFont
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.view_model.state.DayForecast

@Composable
fun ForecastCard(dayForecast: DayForecast, modifier: Modifier = Modifier) {
    Box(modifier = modifier.width(88.dp)) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(top = 12.dp)
                .border(1.dp, WeatherColors.textColor.copy(alpha = 0.08f), RoundedCornerShape(20.dp))
                .background(WeatherColors.whiteToBlack.copy(alpha = 0.7f), RoundedCornerShape(24.dp)),
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .blur(8.dp)
                .height(60.dp),
            painter = painterResource(id = dayForecast.iconRes),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color(0xFF1D2646).copy(alpha = 0.25f))
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                painter = painterResource(id = dayForecast.iconRes),
                contentDescription = null,
            )

            VerticalSpace(16.dp)

            Text(
                modifier = Modifier,
                text = "${dayForecast.temperature}°C",
                fontFamily = UrbanistFont,
                fontSize = 16.sp,
                color = WeatherColors.textColor.copy(alpha = 0.87f),
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
            )

            VerticalSpace(4.dp)

            Text(
                modifier = Modifier,
                text = dayForecast.formattedHour,
                fontFamily = UrbanistFont,
                fontSize = 16.sp,
                color = WeatherColors.textColor.copy(alpha = 0.6f),
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
            )

            VerticalSpace(12.dp)
        }
    }
}

@Preview
@Composable
private fun PreviewForecastCard() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(10) {
            ForecastCard(DayForecast(R.drawable.forcast_test, 25f, "11:00"))
        }
    }
}