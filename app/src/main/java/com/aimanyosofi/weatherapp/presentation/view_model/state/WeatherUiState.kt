package com.aimanyosofi.weatherapp.presentation.view_model.state

import androidx.annotation.DrawableRes

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
    val isDay: Boolean = true,
    val weatherCode: Int = 1,
    val temperature: Float = 0f,
    val description: String = "",
    val lowerTemperature: Float = 0f,
    val higherTemperature: Float = 0f,
)

data class DayForecast(
    val isDay: Boolean,
    val weatherCode: Int,
    val temperature: Double,
    val formattedHour: String,
)

data class WeekForecast(
    val isDay: Boolean,
    val weatherCode: Int,
    val dayName: String,
    val lowerTemperature: Double,
    val higherTemperature: Double,
)