package com.aimanyosofi.weatherapp.domain.model

data class DailyWeather(
    val temperature2MMax: List<Double>,
    val temperature2MMin: List<Double>,
    val time: List<String>,
    val uvIndexMax: List<Double>,
    val weatherCode: List<WeatherCode>
)