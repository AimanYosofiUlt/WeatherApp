package com.aimanyosofi.weatherapp.data.repository

import android.Manifest
import android.location.Geocoder
import androidx.annotation.RequiresPermission
import com.aimanyosofi.weatherapp.domain.model.Location
import com.aimanyosofi.weatherapp.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Tasks

class LocationRepositoryImpl(
    private val geocoder: Geocoder,
    private val fusedLocationClient: FusedLocationProviderClient
) : LocationRepository {
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): Location {
        val googleLocation = Tasks.await(fusedLocationClient.lastLocation)

        val addresses = geocoder.getFromLocation(
            googleLocation.latitude, googleLocation.longitude, 1
        )

        val label = if (!addresses.isNullOrEmpty()) {
            addresses.firstOrNull()?.getAddressLine(0)?.split(", ")?.get(1) ?: "Address not found"
        } else "Unknown"

        return Location(
            latitude = googleLocation.latitude,
            longitude = googleLocation.longitude,
            label = label
        )
    }
}