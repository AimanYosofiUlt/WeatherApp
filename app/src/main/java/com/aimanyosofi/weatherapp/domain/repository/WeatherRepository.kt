package com.aimanyosofi.weatherapp.domain.repository

import com.aimanyosofi.weatherapp.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): Weather
}