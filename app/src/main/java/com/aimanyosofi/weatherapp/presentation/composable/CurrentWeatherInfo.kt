package com.aimanyosofi.weatherapp.presentation.composable

import android.content.res.Resources
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.theme.WeatherDimens
import com.aimanyosofi.weatherapp.presentation.util.WeatherResourceUtil
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState

@Composable
fun CurrentWeatherInfo(
    state: WeatherUiState,
    currentOffset: Dp,
    imageSize: Dp,
    isScrolled: Boolean
) {
    val displayMetrics = Resources.getSystem().displayMetrics

    val widthPixels = displayMetrics.widthPixels
    val density = displayMetrics.density
    val widthDp = widthPixels / density

    val paddingValue = 32.dp

    var rowWidth by remember { mutableFloatStateOf(0f) }

    val boxSize by animateDpAsState(
        if (isScrolled.not()) widthDp.dp else 160.dp,
        tween(1000)
    )

    val imageWidth by animateDpAsState(
        if (isScrolled.not()) 220.dp else 124.dp,
        tween(1000)
    )

    val imageHeight by animateDpAsState(
        if (isScrolled.not()) imageSize else 112.7.dp,
        tween(1000)
    )

    val topPadding by animateDpAsState(
        if (isScrolled.not()) 0.dp else WeatherDimens.mediumPadding,
        tween(1000)
    )
    val boxTopPadding by animateDpAsState(
        if (isScrolled.not()) currentOffset else WeatherDimens.extraLargePadding * 3,
        tween(1000)
    )
    val sidePadding by animateDpAsState(
        if (isScrolled.not()) ((widthDp.dp - rowWidth.dp) / 2) - WeatherDimens.mediumPadding else 0.dp,
        tween(1000)
    )

    val detailTopPadding by animateDpAsState(
        if (isScrolled.not()) (imageSize + WeatherDimens.mediumPadding) else 0.dp,
        tween(1000)
    )

    Column {
        VerticalSpace(boxTopPadding)

        Box(
            modifier = Modifier
                .padding(
                    start = WeatherDimens.mediumPadding,
                    end = WeatherDimens.mediumPadding,
                    bottom = WeatherDimens.mediumPadding
                )
                .fillMaxWidth(),
        ) {
            Box(Modifier.width(boxSize - paddingValue), contentAlignment = Alignment.Center) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                    VerticalSpace(topPadding)
                    Box {
                        WeatherInfoImage(
                            modifier = Modifier.blur(
                                radius = 150.dp,
                                edgeTreatment = BlurredEdgeTreatment.Unbounded
                            ),
                            imageWidth = imageWidth,
                            imageHeight = imageHeight,
                            state = state,
                            colorFilter = ColorFilter.tint(WeatherColors.shadowColor.copy(alpha = 0.6f))
                        )

                        WeatherInfoImage(
                            imageWidth = imageWidth,
                            imageHeight = imageHeight,
                            state = state,
                        )
                    }
                }
            }

            Row(modifier = Modifier.padding(top = detailTopPadding)) {
                Box(modifier = Modifier.weight(1f))

                CurrentWeatherDetails(
                    modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                        rowWidth = layoutCoordinates.size.width / density
                    },
                    currentTemperature = state.currentForecast
                )
                Box(
                    modifier = Modifier
                        .width(sidePadding)
                        .height(50.dp)
                )
            }
        }
    }
}

@Composable
private fun WeatherInfoImage(
    imageWidth: Dp,
    imageHeight: Dp,
    state: WeatherUiState,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null,
) {
    Image(
        modifier = Modifier
            .width(imageWidth)
            .height(imageHeight)
            .then(modifier),
        painter = painterResource(
            id = WeatherResourceUtil.getImageResId(
                state.currentForecast.isDay,
                state.currentForecast.weatherCode
            )
        ),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        colorFilter = colorFilter
    )
}