package com.aimanyosofi.weatherapp.domain.use_cases

import com.aimanyosofi.weatherapp.domain.model.Weather
import com.aimanyosofi.weatherapp.domain.repository.WeatherRepository

class GetWeatherByLocationUseCase(private val repository: WeatherRepository) {
    suspend fun getWeather(latitude: Double, longitude: Double): Weather {
        return repository.getWeather(latitude, longitude)
    }
}
