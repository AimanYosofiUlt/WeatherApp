package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    @SerialName("current")
    val currentWeather: CurrentWeatherDto,

    @SerialName("current_units")
    val currentUnits: CurrentUnitsDto,

    @SerialName("daily")
    val dailyWeather: DailyWeatherDto,

    @SerialName("daily_units")
    val dailyWeatherUnits: DailyWeatherUnitsDto,

    @SerialName("hourly")
    val hourly: HourlyWeatherDto,

    @SerialName("hourly_units")
    val hourlyWeatherUnits: HourlyWeatherUnitsDto,
)