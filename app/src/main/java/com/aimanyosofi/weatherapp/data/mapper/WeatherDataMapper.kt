package com.aimanyosofi.weatherapp.data.mapper

import com.aimanyosofi.weatherapp.data.model.CurrentUnitsDto
import com.aimanyosofi.weatherapp.data.model.CurrentWeatherDto
import com.aimanyosofi.weatherapp.data.model.DailyWeatherDto
import com.aimanyosofi.weatherapp.data.model.DailyWeatherUnitsDto
import com.aimanyosofi.weatherapp.data.model.HourlyWeatherDto
import com.aimanyosofi.weatherapp.data.model.HourlyWeatherUnitsDto
import com.aimanyosofi.weatherapp.data.model.WeatherDto
import com.aimanyosofi.weatherapp.domain.model.CurrentUnits
import com.aimanyosofi.weatherapp.domain.model.CurrentWeather
import com.aimanyosofi.weatherapp.domain.model.DailyWeather
import com.aimanyosofi.weatherapp.domain.model.DailyWeatherUnits
import com.aimanyosofi.weatherapp.domain.model.HourlyWeather
import com.aimanyosofi.weatherapp.domain.model.HourlyWeatherUnits
import com.aimanyosofi.weatherapp.domain.model.Weather

fun WeatherDto.toDomain(): Weather = Weather(
    currentWeather = currentWeather.toDomain(),
    currentUnits = currentUnits.toDomain(),
    dailyWeather = dailyWeather.toDomain(),
    dailyWeatherUnits = dailyWeatherUnits.toDomain(),
    hourly = hourly.toDomain(),
    hourlyWeatherUnits = hourlyWeatherUnits.toDomain()
)

fun CurrentWeatherDto.toDomain() = CurrentWeather(
    apparentTemperature = apparentTemperature,
    interval = interval,
    rain = rain,
    relativeHumidity2M = relativeHumidity2M,
    surfacePressure = surfacePressure,
    temperature2M = temperature2M,
    time = time,
    weatherCode = weatherCode,
    windSpeed10M = windSpeed10M,
    isDay = isDay == 1
)

fun CurrentUnitsDto.toDomain() = CurrentUnits(
    apparentTemperature = apparentTemperature,
    interval = interval,
    rain = rain,
    relativeHumidity2M = relativeHumidity2M,
    surfacePressure = surfacePressure,
    temperature2M = temperature2M,
    time = time,
    weatherCode = weatherCode,
    windSpeed10M = windSpeed10M
)

fun DailyWeatherDto.toDomain() = DailyWeather(
    temperature2MMax = temperature2MMax,
    temperature2MMin = temperature2MMin,
    time = time,
    uvIndexMax = uvIndexMax,
    weatherCode = weatherCode
)

fun DailyWeatherUnitsDto.toDomain() = DailyWeatherUnits(
    temperature2MMax = temperature2MMax,
    temperature2MMin = temperature2MMin,
    time = time,
    uvIndexMax = uvIndexMax,
    weatherCode = weatherCode
)

fun HourlyWeatherDto.toDomain() = HourlyWeather(
    temperature2M = temperature2M,
    time = time,
    weatherCode = weatherCode
)

fun HourlyWeatherUnitsDto.toDomain() = HourlyWeatherUnits(
    temperature2M = temperature2M,
    time = time,
    weatherCode = weatherCode
)
