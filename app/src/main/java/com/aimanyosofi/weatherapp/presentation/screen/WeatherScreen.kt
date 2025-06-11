package com.aimanyosofi.weatherapp.presentation.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.aimanyosofi.weatherapp.presentation.composable.CurrentWeatherInfo
import com.aimanyosofi.weatherapp.presentation.composable.ForecastCard
import com.aimanyosofi.weatherapp.presentation.composable.LocationInfo
import com.aimanyosofi.weatherapp.presentation.composable.VerticalSpace
import com.aimanyosofi.weatherapp.presentation.composable.WeatherDetailCard
import com.aimanyosofi.weatherapp.presentation.composable.WeatherSectionTitle
import com.aimanyosofi.weatherapp.presentation.composable.WeeklyForecastCard
import com.aimanyosofi.weatherapp.presentation.theme.WeatherAppDarkColors
import com.aimanyosofi.weatherapp.presentation.theme.WeatherAppTheme
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors
import com.aimanyosofi.weatherapp.presentation.theme.WeatherDimens
import com.aimanyosofi.weatherapp.presentation.theme.weatherAppLightColors
import com.aimanyosofi.weatherapp.presentation.util.WeatherResourceUtil
import com.aimanyosofi.weatherapp.presentation.view_model.WeatherViewModel
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()
    val isDay = state.currentForecast.isDay
    val currentColors = if (isDay)
        weatherAppLightColors
    else
        WeatherAppDarkColors

    val systemUiController = rememberSystemUiController()
    val statusBarColor = currentColors.primaryToBlack
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = isDay
        )
    }

    WeatherAppTheme(currentColors) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = WeatherColors.primaryToBlack
        ) { innerPadding ->
            WeatherScreenContent(modifier = Modifier.padding(innerPadding), state = state)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherScreenContent(state: WeatherUiState, modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()
    var imageHeight by remember { mutableStateOf(200.dp) }
    var isScrolled by remember { mutableStateOf(false) }
    var shouldSticky by remember { mutableStateOf(true) }
    var currentOffset by remember { mutableStateOf(0.dp) }
    val backgroundBrush = WeatherResourceUtil.getBackgroundColor()

    LaunchedEffect(scrollState) {
        snapshotFlow {
            Pair(scrollState.firstVisibleItemIndex, scrollState.firstVisibleItemScrollOffset)
        }.collect { (index, offset) ->
            if (index == 0) {
                imageHeight = (200 - offset).coerceAtLeast(112).dp
                Int.MAX_VALUE
                isScrolled = offset >= 122
            } else {
                isScrolled = true
            }

            shouldSticky = index == 0 || (index == 1 && offset.dp < 32.dp)
            if (index == 0 && offset.dp <= 24.dp) {
                currentOffset = offset.dp
            }
        }
    }

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundBrush),
        verticalArrangement = Arrangement.spacedBy(WeatherDimens.mediumPadding),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        stickyHeader {
            AnimatedVisibility(
                shouldSticky,
                enter = expandVertically(),
                exit = shrinkVertically(),
            ) {
                Column {
                    VerticalSpace(WeatherDimens.extraLargePadding)
                    LocationInfo(
                        state.locationName,
                        modifier = Modifier,
                    )
                }
            }
        }

        item {
            CurrentWeatherInfo(state, currentOffset, imageHeight, isScrolled)
        }

        item {
            LazyVerticalGrid(
                modifier = Modifier.heightIn(0.dp, 115.dp + 115.dp + WeatherDimens.mediumPadding),
                userScrollEnabled = false,
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                contentPadding = PaddingValues(horizontal = WeatherDimens.mediumPadding)
            ) {
                items(state.weatherDetails) {
                    WeatherDetailCard(it)
                }
            }
        }

        item {
            VerticalSpace(WeatherDimens.mediumPadding)
            WeatherSectionTitle("Today")
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(WeatherDimens.mediumPadding),
                contentPadding = PaddingValues(horizontal = WeatherDimens.mediumPadding)
            ) {
                items(items = state.hourlyForecasts) {
                    ForecastCard(it)
                }
            }
        }

        item {
            VerticalSpace(WeatherDimens.mediumPadding)
            WeatherSectionTitle("Next 7 days")
        }

        item {
            Column(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .border(
                        1.dp,
                        WeatherColors.textColor.copy(alpha = 0.08f),
                        RoundedCornerShape(24.dp)
                    )
                    .clip(RoundedCornerShape(24.dp))
                    .background(WeatherColors.whiteToBlack.copy(alpha = 0.7f))
                    .padding(vertical = 2.dp)
            ) {
                state.dailyForecasts.forEachIndexed { index, weekForecast ->
                    WeeklyForecastCard(
                        weekForecast = weekForecast
                    )

                    if (index != state.dailyForecasts.lastIndex)
                        HorizontalDivider(color = WeatherColors.textColor.copy(alpha = 0.08f))
                }
            }
        }
    }
}




