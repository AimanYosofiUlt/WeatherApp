package com.aimanyosofi.weatherapp.di

import android.location.Geocoder
import com.aimanyosofi.weatherapp.data.repository.LocationRepositoryImpl
import com.aimanyosofi.weatherapp.data.repository.WeatherRepositoryImpl
import com.aimanyosofi.weatherapp.domain.repository.LocationRepository
import com.aimanyosofi.weatherapp.domain.repository.WeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import org.koin.dsl.module
import java.util.Locale

val repositoryModule = module {
    single { HttpClient(Android) }
    factory<Geocoder> { Geocoder(get(), Locale.ENGLISH) }
    factory<FusedLocationProviderClient> { LocationServices.getFusedLocationProviderClient(get()) }
    factory<LocationRepository> { LocationRepositoryImpl(get(), get()) }
    factory<WeatherRepository> { WeatherRepositoryImpl(get()) }
}