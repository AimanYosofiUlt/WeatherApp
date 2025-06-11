package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherDto(
    @SerialName("temperature_2m")
    val temperature: List<Double>,

    @SerialName("time")
    val time: List<String>,

    @SerialName("weather_code")
    val weatherCode: List<Int>
)