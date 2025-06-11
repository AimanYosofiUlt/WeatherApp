package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherUnitsDto(
    @SerialName("temperature_2m")
    val temperatureUnti: String,

    @SerialName("time")
    val timeUnit: String,
)