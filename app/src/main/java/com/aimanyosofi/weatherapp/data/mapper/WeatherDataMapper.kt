package com.aimanyosofi.weatherapp.data.mapper

import com.aimanyosofi.weatherapp.data.model.CLEAR_SKY
import com.aimanyosofi.weatherapp.data.model.CurrentUnitsDto
import com.aimanyosofi.weatherapp.data.model.CurrentWeatherDto
import com.aimanyosofi.weatherapp.data.model.DENSE_INTENSITY_DRIZZLE
import com.aimanyosofi.weatherapp.data.model.DENSE_INTENSITY_FREEZING_DRIZZLE
import com.aimanyosofi.weatherapp.data.model.DEPOSITING_RIME_FOG
import com.aimanyosofi.weatherapp.data.model.DailyWeatherDto
import com.aimanyosofi.weatherapp.data.model.DailyWeatherUnitsDto
import com.aimanyosofi.weatherapp.data.model.FOG
import com.aimanyosofi.weatherapp.data.model.HEAVY_HAIL_THUNDERSTORM
import com.aimanyosofi.weatherapp.data.model.HEAVY_INTENSITY_FREEZING_RAIN
import com.aimanyosofi.weatherapp.data.model.HEAVY_INTENSITY_RAIN
import com.aimanyosofi.weatherapp.data.model.HEAVY_INTENSITY_SNOW_FALL
import com.aimanyosofi.weatherapp.data.model.HEAVY_SNOW_SHOWERS
import com.aimanyosofi.weatherapp.data.model.HourlyWeatherDto
import com.aimanyosofi.weatherapp.data.model.HourlyWeatherUnitsDto
import com.aimanyosofi.weatherapp.data.model.LIGHT_DRIZZLE
import com.aimanyosofi.weatherapp.data.model.LIGHT_FREEZING_DRIZZLE
import com.aimanyosofi.weatherapp.data.model.LIGHT_FREEZING_RAIN
import com.aimanyosofi.weatherapp.data.model.MAINLY_CLEAR
import com.aimanyosofi.weatherapp.data.model.MODERATE_DRIZZLE
import com.aimanyosofi.weatherapp.data.model.MODERATE_RAIN
import com.aimanyosofi.weatherapp.data.model.MODERATE_RAIN_SHOWERS
import com.aimanyosofi.weatherapp.data.model.MODERATE_SNOW_FALL
import com.aimanyosofi.weatherapp.data.model.MODERATE_THUNDERSTORM
import com.aimanyosofi.weatherapp.data.model.OVERCAST
import com.aimanyosofi.weatherapp.data.model.PARTLY_CLOUDY
import com.aimanyosofi.weatherapp.data.model.SLIGHT_RAIN_RAIN
import com.aimanyosofi.weatherapp.data.model.SLIGHT_RAIN_SHOWERS
import com.aimanyosofi.weatherapp.data.model.SLIGHT_SNOW_FALL
import com.aimanyosofi.weatherapp.data.model.SLIGHT_SNOW_SHOWERS
import com.aimanyosofi.weatherapp.data.model.SLIGHT_THUNDERSTORM
import com.aimanyosofi.weatherapp.data.model.SNOW_GRAINS
import com.aimanyosofi.weatherapp.data.model.VIOLENT_RAIN_SHOWERS
import com.aimanyosofi.weatherapp.data.model.WeatherDto
import com.aimanyosofi.weatherapp.domain.model.CurrentUnits
import com.aimanyosofi.weatherapp.domain.model.CurrentWeather
import com.aimanyosofi.weatherapp.domain.model.DailyWeather
import com.aimanyosofi.weatherapp.domain.model.DailyWeatherUnits
import com.aimanyosofi.weatherapp.domain.model.HourlyWeather
import com.aimanyosofi.weatherapp.domain.model.HourlyWeatherUnits
import com.aimanyosofi.weatherapp.domain.model.Weather
import com.aimanyosofi.weatherapp.domain.model.WeatherCode

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
    relativeHumidity = relativeHumidity,
    surfacePressure = surfacePressure,
    temperature = temperature,
    time = time,
    weatherCode = weatherCode.toWeatherType(),
    windSpeed = windSpeed,
    isDay = isDay == 1
)

fun CurrentUnitsDto.toDomain() = CurrentUnits(
    apparentTemperatureUnit = apparentTemperatureUnit,
    rainUnit = rainUnit,
    relativeHumidityUnit = relativeHumidityUnit,
    surfacePressureUnit = surfacePressureUnit,
    temperatureUnit = temperatureUnit,
    timeUnit = timeUnit,
    windSpeedUnit = windSpeedUnit
)

fun DailyWeatherDto.toDomain() = DailyWeather(
    temperature2MMax = temperatureMax,
    temperature2MMin = temperatureMin,
    time = time,
    uvIndexMax = uvIndexMax,
    weatherCode = weatherCode.map { it.toWeatherType() }
)

fun DailyWeatherUnitsDto.toDomain() = DailyWeatherUnits(
    temperatureMaxUnit = temperatureMaxUnit,
    temperatureMinUnit = temperatureMinUnit,
    timeUnit = timeUnit,
    uvIndexUnit = uvIndexUnit,
)

fun HourlyWeatherDto.toDomain() = HourlyWeather(
    temperature = temperature,
    time = time,
    weatherCode = weatherCode.map { it.toWeatherType() }
)

fun HourlyWeatherUnitsDto.toDomain() = HourlyWeatherUnits(
    temperatureUnit = temperatureUnti,
    timeUnti = timeUnit,
)

fun Int.toWeatherType(): WeatherCode {
    return when (this) {
        CLEAR_SKY -> WeatherCode.CLEAR_SKY
        MAINLY_CLEAR -> WeatherCode.MAINLY_CLEAR
        PARTLY_CLOUDY -> WeatherCode.PARTLY_CLOUDY
        OVERCAST -> WeatherCode.OVERCAST
        FOG -> WeatherCode.FOG
        DEPOSITING_RIME_FOG -> WeatherCode.DEPOSITING_RIME_FOG
        LIGHT_DRIZZLE -> WeatherCode.LIGHT_DRIZZLE
        MODERATE_DRIZZLE -> WeatherCode.MODERATE_DRIZZLE
        DENSE_INTENSITY_DRIZZLE -> WeatherCode.DENSE_INTENSITY_DRIZZLE
        LIGHT_FREEZING_DRIZZLE -> WeatherCode.LIGHT_FREEZING_DRIZZLE
        DENSE_INTENSITY_FREEZING_DRIZZLE -> WeatherCode.DENSE_INTENSITY_FREEZING_DRIZZLE
        SLIGHT_RAIN_RAIN -> WeatherCode.SLIGHT_RAIN_RAIN
        MODERATE_RAIN -> WeatherCode.MODERATE_RAIN
        HEAVY_INTENSITY_RAIN -> WeatherCode.HEAVY_INTENSITY_RAIN
        LIGHT_FREEZING_RAIN -> WeatherCode.LIGHT_FREEZING_RAIN
        HEAVY_INTENSITY_FREEZING_RAIN -> WeatherCode.HEAVY_INTENSITY_FREEZING_RAIN
        SLIGHT_SNOW_FALL -> WeatherCode.SLIGHT_SNOW_FALL
        MODERATE_SNOW_FALL -> WeatherCode.MODERATE_SNOW_FALL
        HEAVY_INTENSITY_SNOW_FALL -> WeatherCode.HEAVY_INTENSITY_SNOW_FALL
        SNOW_GRAINS -> WeatherCode.SNOW_GRAINS
        SLIGHT_RAIN_SHOWERS -> WeatherCode.SLIGHT_RAIN_SHOWERS
        MODERATE_RAIN_SHOWERS -> WeatherCode.MODERATE_RAIN_SHOWERS
        VIOLENT_RAIN_SHOWERS -> WeatherCode.MODERATE_RAIN_SHOWERS
        SLIGHT_SNOW_SHOWERS -> WeatherCode.SLIGHT_SNOW_SHOWERS
        HEAVY_SNOW_SHOWERS -> WeatherCode.HEAVY_SNOW_SHOWERS
        MODERATE_THUNDERSTORM -> WeatherCode.MODERATE_THUNDERSTORM
        SLIGHT_THUNDERSTORM -> WeatherCode.SLIGHT_THUNDERSTORM
        HEAVY_HAIL_THUNDERSTORM -> WeatherCode.HEAVY_HAIL_THUNDERSTORM
        else -> WeatherCode.HEAVY_HAIL_THUNDERSTORM
    }
}