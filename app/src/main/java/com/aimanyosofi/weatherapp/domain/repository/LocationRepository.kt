package com.aimanyosofi.weatherapp.domain.repository

import com.aimanyosofi.weatherapp.domain.models.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}