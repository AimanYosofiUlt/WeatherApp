package com.aimanyosofi.weatherapp.domain.model

data class CurrentUnits(
    val apparentTemperatureUnit: String,
    val rainUnit: String,
    val relativeHumidityUnit: String,
    val surfacePressureUnit: String,
    val temperatureUnit: String,
    val timeUnit: String,
    val windSpeedUnit: String
)