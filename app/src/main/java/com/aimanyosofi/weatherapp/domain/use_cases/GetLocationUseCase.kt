package com.aimanyosofi.weatherapp.domain.use_cases

import com.aimanyosofi.weatherapp.domain.model.Location
import com.aimanyosofi.weatherapp.domain.repository.LocationRepository

class GetLocationUseCase(private val repository: LocationRepository) {
    suspend fun getCurrentLocation(): Location {
        return repository.getCurrentLocation()
    }
}