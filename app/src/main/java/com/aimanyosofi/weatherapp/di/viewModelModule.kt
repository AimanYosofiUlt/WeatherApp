package com.aimanyosofi.weatherapp.di

import com.aimanyosofi.weatherapp.presentation.view_model.WeatherViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::WeatherViewModel)
}