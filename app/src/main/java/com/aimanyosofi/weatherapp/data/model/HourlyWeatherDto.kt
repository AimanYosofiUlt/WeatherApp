package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherDto(
    @SerialName("temperature_2m")
    val temperature2M: List<Double>,

    @SerialName("time")
    val time: List<String>,

    @SerialName("weather_code")
    val weatherCode: List<Int>
)