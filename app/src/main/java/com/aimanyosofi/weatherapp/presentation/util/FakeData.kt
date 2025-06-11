package com.aimanyosofi.weatherapp.presentation.util

import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.presentation.view_model.state.CurrentForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.DayForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherDetail
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast

object FakeData {
    fun getWeatherFakeData(): WeatherUiState {
        val isDay = true
        val weatherCode = 1
        return WeatherUiState(
            locationName = "Baghdad",
            weatherDetails = listOf(
                WeatherDetail(R.drawable.fast_wind, "Wind", "13 KM/h"),
                WeatherDetail(R.drawable.humidity, "Humidity", "24%"),
                WeatherDetail(R.drawable.rain, "Rain", "2%"),
                WeatherDetail(R.drawable.uv_02, "UV Index", "2"),
                WeatherDetail(R.drawable.arrow_down_05, "Pressure", "1012 hPa"),
                WeatherDetail(R.drawable.temperature, "Feels like", "22°C"),
            ),
            currentForecast = CurrentForecast(
                isDay, weatherCode, 24f, "Partly cloudy", 20f, 32f
            ),
            hourlyForecasts = listOf(
                DayForecast(isDay, 0, 25.0, "11:00"),
                DayForecast(isDay, 1, 25.0, "12:00"),
                DayForecast(isDay, 2, 25.0, "01:00"),
                DayForecast(isDay, 3, 25.0, "02:00"),
            ),
            dailyForecasts = listOf(
                WeekForecast(isDay, 45, "Monday", 20.0, 32.0),
                WeekForecast(isDay, 48, "Tuesday", 20.0, 32.0),
                WeekForecast(isDay, 51, "Wednesday", 20.0, 32.0),
                WeekForecast(isDay, 53, "Thursday", 20.0, 32.0),
                WeekForecast(isDay, 55, "Friday", 20.0, 32.0),
                WeekForecast(isDay, 56, "Saturday", 20.0, 32.0),
                WeekForecast(isDay, 67, "Sunday", 20.0, 32.0),
            )
        )
    }
}