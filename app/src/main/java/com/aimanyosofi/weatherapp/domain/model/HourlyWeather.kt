package com.aimanyosofi.weatherapp.domain.model

data class HourlyWeather(
    val temperature: List<Double>,
    val time: List<String>,
    val weatherCode: List<WeatherCode>
)