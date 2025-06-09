package com.aimanyosofi.weatherapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aimanyosofi.weatherapp.presentation.composable.CurrentWeatherDetails
import com.aimanyosofi.weatherapp.presentation.composable.ForecastCard
import com.aimanyosofi.weatherapp.presentation.composable.LocationInfo
import com.aimanyosofi.weatherapp.presentation.composable.WeatherDetailCard
import com.aimanyosofi.weatherapp.presentation.composable.WeeklyForecastCard
import com.aimanyosofi.weatherapp.presentation.theme.UrbanistFont
import com.aimanyosofi.weatherapp.presentation.theme.WeatherAppDarkColors
import com.aimanyosofi.weatherapp.presentation.theme.WeatherAppTheme
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.theme.weatherAppLightColors
import com.aimanyosofi.weatherapp.presentation.view_model.WeatherViewModel
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()
    val currentColors = if (state.currentForecast.isDay)
        weatherAppLightColors
    else
        WeatherAppDarkColors
    WeatherAppTheme(currentColors) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = WeatherColors.primaryToBlack
        ) { innerPadding ->
            WeatherScreenContent(modifier = Modifier.padding(innerPadding), state = state)
        }
    }
}

@Composable
fun WeatherScreenContent(state: WeatherUiState, modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    var imageSize by remember { mutableStateOf(200.dp) }
    var currentOffset by remember { mutableStateOf(0) }

    LaunchedEffect(scrollState) {
        snapshotFlow {
            Pair(scrollState.firstVisibleItemIndex, scrollState.firstVisibleItemScrollOffset)
        }.collect { (index, offset) ->
            if (index == 0) {
                val newValue = (200 - offset).coerceAtLeast(112).dp
                currentOffset = offset
                imageSize = newValue
                Int.MAX_VALUE
            }
        }
    }


    val backgroundBrush = Brush.linearGradient(
        listOf(
            WeatherColors.primaryToBlack,
            WeatherColors.primaryToBlack,
            WeatherColors.whiteToBlack,
            WeatherColors.whiteToBlack
        )
    )

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        item {
            LocationInfo(state.locationName)
            Image(
                modifier = Modifier
                    .width(220.dp)
                    .height(imageSize),
                painter = painterResource(id = state.currentForecast.iconRes),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
            CurrentWeatherDetails(state.currentForecast)
        }

        item {
            LazyVerticalGrid(
                modifier = Modifier.heightIn(0.dp, 115.dp + 115.dp + 12.dp),
                userScrollEnabled = false,
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                items(state.weatherDetails) {
                    WeatherDetailCard(it)
                }
            }
        }

        item {
            WeatherSectionTitle("Today")
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                items(items = state.hourlyForecasts) {
                    ForecastCard(it)
                }
            }
        }

        item {
            WeatherSectionTitle("Next 7 days")
        }

        items(items = state.dailyForecasts) { weekForecast ->
            WeeklyForecastCard(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                weekForecast = weekForecast
            )
        }
    }
}

@Composable
private fun WeatherSectionTitle(title: String) {
    Text(
        modifier = Modifier,
        text = title,
        fontFamily = UrbanistFont,
        fontSize = 20.sp,
        color = WeatherColors.textColor,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center,
        style = TextStyle(lineHeight = TextUnit.Unspecified, letterSpacing = 0.25.sp)
    )
}
