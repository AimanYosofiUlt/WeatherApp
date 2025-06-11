package com.aimanyosofi.weatherapp.domain.model

data class CurrentWeather(
    val apparentTemperature: Double,
    val interval: Double,
    val rain: Double,
    val relativeHumidity: Double,
    val surfacePressure: Double,
    val temperature: Double,
    val time: String,
    val weatherCode: WeatherCode,
    val windSpeed: Double,
    val isDay: Boolean,
)