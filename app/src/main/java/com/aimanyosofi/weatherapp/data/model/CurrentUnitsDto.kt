package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnitsDto(
    @SerialName("apparent_temperature")
    val apparentTemperature: String,

    @SerialName("interval")
    val interval: String,

    @SerialName("rain")
    val rain: String,

    @SerialName("relative_humidity_2m")
    val relativeHumidity2M: String,

    @SerialName("surface_pressure")
    val surfacePressure: String,

    @SerialName("temperature_2m")
    val temperature2M: String,

    @SerialName("time")
    val time: String,

    @SerialName("weather_code")
    val weatherCode: String,

    @SerialName("wind_speed_10m")
    val windSpeed10M: String
)