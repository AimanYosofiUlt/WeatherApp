package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnitsDto(
    @SerialName("apparent_temperature")
    val apparentTemperatureUnit: String,

    @SerialName("rain")
    val rainUnit: String,

    @SerialName("relative_humidity_2m")
    val relativeHumidityUnit: String,

    @SerialName("surface_pressure")
    val surfacePressureUnit: String,

    @SerialName("temperature_2m")
    val temperatureUnit: String,

    @SerialName("time")
    val timeUnit: String,

    @SerialName("wind_speed_10m")
    val windSpeedUnit: String
)