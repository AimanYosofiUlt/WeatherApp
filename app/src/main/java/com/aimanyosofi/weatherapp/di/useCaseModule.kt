package com.aimanyosofi.weatherapp.di

import com.aimanyosofi.weatherapp.domain.use_cases.GetCurrentLocationUseCase
import com.aimanyosofi.weatherapp.domain.use_cases.GetCurrentWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetCurrentWeatherUseCase(get()) }
    factory { GetCurrentLocationUseCase(get()) }
}