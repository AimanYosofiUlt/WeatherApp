package com.aimanyosofi.weatherapp.domain.repository

import com.aimanyosofi.weatherapp.domain.model.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}