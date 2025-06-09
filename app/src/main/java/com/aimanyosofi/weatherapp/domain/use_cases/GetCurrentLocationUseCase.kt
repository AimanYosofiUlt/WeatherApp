package com.aimanyosofi.weatherapp.domain.use_cases

import com.aimanyosofi.weatherapp.domain.models.Location
import com.aimanyosofi.weatherapp.domain.repository.LocationRepository

class GetCurrentLocationUseCase(private val repository: LocationRepository) {
    suspend fun getCurrentLocation(): Location {
        return repository.getCurrentLocation()
    }
}