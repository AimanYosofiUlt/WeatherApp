package com.aimanyosofi.weatherapp.domain.use_cases

import com.aimanyosofi.weatherapp.domain.models.Weather
import com.aimanyosofi.weatherapp.domain.repository.WeatherRepository

class GetCurrentWeatherUseCase(private val repository: WeatherRepository) {
    suspend fun getWeather(latitude: Double, longitude: Double): Weather {
        return repository.getWeather(latitude, longitude)
    }
}
