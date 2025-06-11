package com.aimanyosofi.weatherapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("apparent_temperature")
    val apparentTemperature: Double,

    @SerialName("interval")
    val interval: Double,

    @SerialName("rain")
    val rain: Double,

    @SerialName("relative_humidity_2m")
    val relativeHumidity: Double,

    @SerialName("surface_pressure")
    val surfacePressure: Double,

    @SerialName("temperature_2m")
    val temperature: Double,

    @SerialName("time")
    val time: String,

    @SerialName("weather_code")
    val weatherCode: Int,

    @SerialName("wind_speed_10m")
    val windSpeed: Double,

    @SerialName("is_day")
    val isDay: Int
)