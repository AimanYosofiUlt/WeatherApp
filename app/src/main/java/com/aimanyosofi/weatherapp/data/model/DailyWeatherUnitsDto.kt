package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherUnitsDto(
    @SerialName("temperature_2m_max")
    val temperatureMaxUnit: String,

    @SerialName("temperature_2m_min")
    val temperatureMinUnit: String,

    @SerialName("time")
    val timeUnit: String,

    @SerialName("uv_index_max")
    val uvIndexUnit: String,
)