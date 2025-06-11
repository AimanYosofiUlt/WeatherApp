package com.aimanyosofi.weatherapp.domain.model

data class Weather(
    val currentWeather: CurrentWeather,
    val currentUnits: CurrentUnits,
    val dailyWeather: DailyWeather,
    val dailyWeatherUnits: DailyWeatherUnits,
    val hourly: HourlyWeather,
    val hourlyWeatherUnits: HourlyWeatherUnits,
)

data class CurrentWeather(
    val apparentTemperature: Double,
    val interval: Double,
    val rain: Double,
    val relativeHumidity2M: Double,
    val surfacePressure: Double,
    val temperature2M: Double,
    val time: String,
    val weatherCode: Int,
    val windSpeed10M: Double,
    val isDay: Boolean,
)

data class CurrentUnits(
    val apparentTemperature: String,
    val interval: String,
    val rain: String,
    val relativeHumidity2M: String,
    val surfacePressure: String,
    val temperature2M: String,
    val time: String,
    val weatherCode: String,
    val windSpeed10M: String
)

data class DailyWeather(
    val temperature2MMax: List<Double>,
    val temperature2MMin: List<Double>,
    val time: List<String>,
    val uvIndexMax: List<Double>,
    val weatherCode: List<Int>
)

data class DailyWeatherUnits(
    val temperature2MMax: String,
    val temperature2MMin: String,
    val time: String,
    val uvIndexMax: String,
    val weatherCode: String
)

data class HourlyWeather(
    val temperature2M: List<Double>,
    val time: List<String>,
    val weatherCode: List<Int>
)

data class HourlyWeatherUnits(
    val temperature2M: String,
    val time: String,
    val weatherCode: String
)