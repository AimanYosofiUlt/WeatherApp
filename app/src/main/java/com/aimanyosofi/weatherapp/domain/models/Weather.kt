package com.aimanyosofi.weatherapp.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    @SerialName("current")
    val currentWeather: CurrentWeather,

    @SerialName("current_units")
    val currentUnits: CurrentUnits,

    @SerialName("daily")
    val dailyWeather: DailyWeather,

    @SerialName("daily_units")
    val dailyWeatherUnits: DailyWeatherUnits,

    @SerialName("hourly")
    val hourly: HourlyWeather,

    @SerialName("hourly_units")
    val hourlyWeatherUnits: HourlyWeatherUnits,
)

@Serializable
data class CurrentWeather(
    @SerialName("apparent_temperature")
    val apparentTemperature: Double,

    @SerialName("interval")
    val interval: Double,

    @SerialName("rain")
    val rain: Double,

    @SerialName("relative_humidity_2m")
    val relativeHumidity2M: Double,

    @SerialName("surface_pressure")
    val surfacePressure: Double,

    @SerialName("temperature_2m")
    val temperature2M: Double,

    @SerialName("time")
    val time: String,

    @SerialName("weather_code")
    val weatherCode: Double,

    @SerialName("wind_speed_10m")
    val windSpeed10M: Double
)

@Serializable
data class CurrentUnits(
    @SerialName("apparent_temperature")
    val apparent_temperature: String,

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

@Serializable
data class DailyWeather(
    @SerialName("temperature_2m_max")
    val temperature2MMax: List<Double>,

    @SerialName("temperature_2m_min")
    val temperature2MMin: List<Double>,

    @SerialName("time")
    val time: List<String>,

    @SerialName("uv_index_max")
    val uvIndexMax: List<Double>,

    @SerialName("weather_code")
    val weatherCode: List<Double>
)

@Serializable
data class DailyWeatherUnits(
    @SerialName("temperature_2m_max")
    val temperature2MMax: String,

    @SerialName("temperature_2m_min")
    val temperature2MMin: String,

    @SerialName("time")
    val time: String,

    @SerialName("uv_index_max")
    val uvIndexMax: String,

    @SerialName("weather_code")
    val weatherCode: String
)

@Serializable
data class HourlyWeather(
    @SerialName("temperature_2m")
    val temperature2M: List<Double>,

    @SerialName("time")
    val time: List<String>,

    @SerialName("weather_code")
    val weatherCode: List<Double>
)

@Serializable
data class HourlyWeatherUnits(
    @SerialName("temperature_2m")
    val temperature2M: String,

    @SerialName("time")
    val time: String,

    @SerialName("weather_code")
    val weatherCode: String
)