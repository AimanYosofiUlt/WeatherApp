package com.aimanyosofi.weatherapp.presentation.mapper

import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.domain.model.Weather
import com.aimanyosofi.weatherapp.presentation.util.WeatherResourceUtil
import com.aimanyosofi.weatherapp.presentation.util.formatTo12Hour
import com.aimanyosofi.weatherapp.presentation.util.getDayName
import com.aimanyosofi.weatherapp.presentation.view_model.state.CurrentForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.DayForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherDetail
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast

fun Weather.toUiState(locationLabel: String): WeatherUiState {
    val weatherCode = currentWeather.weatherCode
    val isDay = currentWeather.isDay
   return WeatherUiState(
        locationName = locationLabel,
        weatherDetails = listOf(
            WeatherDetail(
                R.drawable.fast_wind,
                "Wind",
                "${currentWeather.windSpeed} ${currentUnits.windSpeedUnit}"
            ),
            WeatherDetail(
                R.drawable.humidity,
                "Humidity",
                "${currentWeather.relativeHumidity}%"
            ),
            WeatherDetail(R.drawable.rain, "Rain", "${currentWeather.rain}%"),
            WeatherDetail(
                R.drawable.uv_02,
                "UV Index",
                dailyWeather.uvIndexMax.first().toString()
            ),
            WeatherDetail(
                R.drawable.arrow_down_05,
                "Pressure",
                "${currentWeather.surfacePressure} ${currentUnits.surfacePressureUnit}"
            ),
            WeatherDetail(
                R.drawable.temperature,
                "Feels like",
                "${currentWeather.apparentTemperature} ${currentUnits.apparentTemperatureUnit}"
            ),
        ),
        currentForecast = CurrentForecast(
            isDay, weatherCode, 24f, WeatherResourceUtil.getName(weatherCode), 20f, 32f
        ),
        hourlyForecasts = List(hourly.time.size) { index ->
            DayForecast(
                isDay = isDay,
                weatherCode = hourly.weatherCode[index],
                temperature = hourly.temperature[index],
                formattedHour = hourly.time[index].formatTo12Hour("yyyy-MM-dd'T'HH:mm")
            )
        },
        dailyForecasts = List(dailyWeather.time.size) { index ->
            WeekForecast(
                isDay = isDay,
                weatherCode = dailyWeather.weatherCode[index],
                dayName = dailyWeather.time[index].getDayName("yyyy-MM-dd"),
                lowerTemperature = dailyWeather.temperature2MMin[index],
                higherTemperature = dailyWeather.temperature2MMax[index],
            )
        }
    )
}
