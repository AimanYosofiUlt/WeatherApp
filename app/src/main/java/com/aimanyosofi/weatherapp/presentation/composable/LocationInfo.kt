package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
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

@Composable
fun LocationInfo(locationName: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.location_05),
            contentDescription = null,
            colorFilter = ColorFilter.tint(WeatherColors.textColor)
        )

        HorizontalSpace(4.dp)

        Text(
            modifier = Modifier,
            text = locationName,
            fontFamily = UrbanistFont,
            fontSize = 20.sp,
            color = WeatherColors.textColor.copy(alpha = 0.87f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )
    }
}