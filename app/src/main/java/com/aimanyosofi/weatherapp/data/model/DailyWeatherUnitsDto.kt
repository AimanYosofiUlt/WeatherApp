package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherUnitsDto(
    @SerialName("temperature_2m_max")
    val temperature2MMax: String,

    @SerialName("temperature_2m_min")
    val temperature2MMin: String,

    @SerialName("time")
    val time: String,

    @SerialName("uv_index_max")
    val uvIndexMax: String,

    @SerialName("weather_code")
    val weatherCode: String
)