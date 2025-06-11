package com.aimanyosofi.weatherapp.presentation.util

import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.domain.model.WeatherCode
import com.aimanyosofi.weatherapp.presentation.view_model.state.CurrentForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.DayForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherDetail
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast

object FakeData {
    fun getWeatherFakeData(): WeatherUiState {
        val isDay = true
        val weatherCode = WeatherCode.CLEAR_SKY
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
                DayForecast(isDay, WeatherCode.CLEAR_SKY, 25.0, "11:00"),
                DayForecast(isDay, WeatherCode.MAINLY_CLEAR, 25.0, "12:00"),
                DayForecast(isDay, WeatherCode.PARTLY_CLOUDY, 25.0, "01:00"),
                DayForecast(isDay, WeatherCode.OVERCAST, 25.0, "02:00"),
            ),
            dailyForecasts = listOf(
                WeekForecast(isDay, WeatherCode.FOG, "Monday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.DEPOSITING_RIME_FOG, "Tuesday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.LIGHT_DRIZZLE, "Wednesday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.MODERATE_DRIZZLE, "Thursday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.DENSE_INTENSITY_DRIZZLE, "Friday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.LIGHT_FREEZING_DRIZZLE, "Saturday", 20.0, 32.0),
                WeekForecast(isDay, WeatherCode.DENSE_INTENSITY_FREEZING_DRIZZLE, "Sunday", 20.0, 32.0),
            )
        )
    }
}