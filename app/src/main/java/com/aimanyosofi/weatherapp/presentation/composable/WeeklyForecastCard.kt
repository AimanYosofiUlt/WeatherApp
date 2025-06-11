package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
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
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast

@Composable
fun WeeklyForecastCard(modifier: Modifier = Modifier, weekForecast: WeekForecast) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = weekForecast.dayName,
            fontFamily = UrbanistFont,
            fontSize = 16.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .height(32.dp)
                    .blur(16.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded),
                painter = painterResource(
                    id = WeatherResourceUtil.getImageResId(
                        isDay = weekForecast.isDay,
                        weatherCode = weekForecast.weatherCode
                    )
                ),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Image(
                modifier = Modifier
                    .height(32.dp),
                painter = painterResource(
                    id = WeatherResourceUtil.getImageResId(
                        isDay = weekForecast.isDay,
                        weatherCode = weekForecast.weatherCode
                    )
                ),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }

        Row(
            Modifier,
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.arrow_top_04),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(WeatherColors.textColor.copy(alpha = 0.87f))
            )

            HorizontalSpace(4.dp)

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

            HorizontalSpace(4.dp)

            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .width(1.dp)
                    .background(WeatherColors.textColor.copy(alpha = 0.24f)),
            )

            HorizontalSpace(4.dp)

            Image(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.arrow_down_04),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                colorFilter = ColorFilter.tint(WeatherColors.textColor.copy(alpha = 0.87f))
            )

            HorizontalSpace(4.dp)

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
}