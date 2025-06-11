package com.aimanyosofi.weatherapp.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aimanyosofi.weatherapp.domain.use_cases.GetLocationUseCase
import com.aimanyosofi.weatherapp.domain.use_cases.GetWeatherUseCase
import com.aimanyosofi.weatherapp.presentation.mapper.toUiState
import com.aimanyosofi.weatherapp.presentation.util.FakeData
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(WeatherUiState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            FakeData.getWeatherFakeData()
        }

        getWeatherData()
    }

    private fun getWeatherData() = viewModelScope.launch(Dispatchers.IO) {
        val currentLocation = getLocationUseCase.getCurrentLocation()
        val weather = getWeatherUseCase.getWeather(
            currentLocation.latitude,
            currentLocation.longitude
        )

        _state.update {
            weather.toUiState(currentLocation.label)
        }
    }
}