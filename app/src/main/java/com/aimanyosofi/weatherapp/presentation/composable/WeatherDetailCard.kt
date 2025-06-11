package com.aimanyosofi.weatherapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aimanyosofi.weatherapp.presentation.theme.UrbanistFont
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherDetail

@Composable
fun WeatherDetailCard(
    weatherDetail: WeatherDetail,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(1.dp, WeatherColors.textColor.copy(alpha = 0.08f), RoundedCornerShape(24.dp))
            .background(WeatherColors.whiteToBlack.copy(alpha = 0.7f), RoundedCornerShape(24.dp))
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = weatherDetail.iconRes),
            contentDescription = null,
        )

        VerticalSpace(8.dp)

        Text(
            modifier = Modifier,
            text = weatherDetail.value,
            fontFamily = UrbanistFont,
            fontSize = 20.sp,
            color = WeatherColors.textColor.copy(alpha = 0.87f),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )

        VerticalSpace(2.dp)

        Text(
            modifier = Modifier,
            text = weatherDetail.label,
            fontFamily = UrbanistFont,
            fontSize = 14.sp,
            color = WeatherColors.textColor.copy(alpha = 0.6f),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
        )
    }
}