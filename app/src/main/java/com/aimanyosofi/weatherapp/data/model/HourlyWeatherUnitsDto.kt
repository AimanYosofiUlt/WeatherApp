package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherUnitsDto(
    @SerialName("temperature_2m")
    val temperature2M: String,

    @SerialName("time")
    val time: String,

    @SerialName("weather_code")
    val weatherCode: String
)