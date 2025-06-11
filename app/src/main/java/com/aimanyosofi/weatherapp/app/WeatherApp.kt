package com.aimanyosofi.weatherapp.app

import android.app.Application
import com.aimanyosofi.weatherapp.di.presentationModule
import com.aimanyosofi.weatherapp.di.repositoryModule
import com.aimanyosofi.weatherapp.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WeatherApp)
            modules(repositoryModule, useCaseModule, presentationModule)
        }
    }
}