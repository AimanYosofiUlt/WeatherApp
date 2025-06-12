package com.aimanyosofi.weatherapp.di

import com.aimanyosofi.weatherapp.domain.use_cases.GetLocationUseCase
import com.aimanyosofi.weatherapp.domain.use_cases.GetWeatherByLocationUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetWeatherByLocationUseCase(get()) }
    factory { GetLocationUseCase(get()) }
}