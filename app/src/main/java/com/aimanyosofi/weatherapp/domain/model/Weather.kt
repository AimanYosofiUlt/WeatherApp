package com.aimanyosofi.weatherapp.domain.model

data class Weather(
    val currentWeather: CurrentWeather,
    val currentUnits: CurrentUnits,
    val dailyWeather: DailyWeather,
    val dailyWeatherUnits: DailyWeatherUnits,
    val hourly: HourlyWeather,
    val hourlyWeatherUnits: HourlyWeatherUnits,
)