package com.aimanyosofi.weatherapp.di

import com.aimanyosofi.weatherapp.domain.use_cases.GetLocationUseCase
import com.aimanyosofi.weatherapp.domain.use_cases.GetWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetWeatherUseCase(get()) }
    factory { GetLocationUseCase(get()) }
}