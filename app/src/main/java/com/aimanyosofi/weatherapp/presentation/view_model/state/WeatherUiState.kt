package com.aimanyosofi.weatherapp.presentation.view_model.state

import androidx.annotation.DrawableRes
import com.aimanyosofi.weatherapp.R

data class WeatherUiState(
    val locationName: String = "",
    val weatherDetails: List<WeatherDetail> = emptyList(),
    val currentForecast: CurrentForecast = CurrentForecast(),
    val hourlyForecasts: List<DayForecast> = emptyList(),
    val dailyForecasts: List<WeekForecast> = emptyList(),
)

data class WeatherDetail(
    @DrawableRes val iconRes: Int,
    val label: String,
    val value: String,
)

data class CurrentForecast(
    @DrawableRes val iconRes: Int = R.drawable.forcast_test,
    val temperature: Float = 0f,
    val description: String = "",
    val lowerTemperature: Float = 0f,
    val higherTemperature: Float = 0f,
    val isDay:Boolean = true
)

data class DayForecast(
    @DrawableRes val iconRes: Int,
    val temperature: Float,
    val formattedHour: String,
)

data class WeekForecast(
    @DrawableRes val iconRes: Int,
    val dayName: String,
    val lowerTemperature: Float,
    val higherTemperature: Float,
)