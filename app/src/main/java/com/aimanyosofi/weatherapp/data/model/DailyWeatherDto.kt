package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherDto(
    @SerialName("temperature_2m_max")
    val temperature2MMax: List<Double>,

    @SerialName("temperature_2m_min")
    val temperature2MMin: List<Double>,

    @SerialName("time")
    val time: List<String>,

    @SerialName("uv_index_max")
    val uvIndexMax: List<Double>,

    @SerialName("weather_code")
    val weatherCode: List<Int>
)