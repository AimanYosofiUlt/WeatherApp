package com.aimanyosofi.weatherapp.presentation.view_model

import androidx.lifecycle.ViewModel
import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.presentation.view_model.state.CurrentForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.DayForecast
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherDetail
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeatherUiState
import com.aimanyosofi.weatherapp.presentation.view_model.state.WeekForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WeatherViewModel : ViewModel() {
    private val _state = MutableStateFlow(WeatherUiState())
    val state = _state.asStateFlow()

    init {
        getWeatherData()

//        viewModelScope.launch {
//            delay(1000)
//            _state.update { it.copy(currentForecast = it.currentForecast.copy(isDay = false)) }
//        }
    }

    private fun getWeatherData() {
        _state.update {
            it.copy(
                locationName = "Baghdad",
                weatherDetails = listOf(
                    WeatherDetail(R.drawable.fast_wind, "Wind", "13 KM/h"),
                    WeatherDetail(R.drawable.humidity, "Humidity", "24%"),
                    WeatherDetail(R.drawable.rain, "Rain", "2%"),
                    WeatherDetail(R.drawable.uv_02, "UV Index", "2"),
                    WeatherDetail(R.drawable.arrow_down_05, "Pressure", "1012 hPa"),
                    WeatherDetail(R.drawable.temperature, "Feels like", "22°C"),
                ),
                currentForecast = CurrentForecast(
                    R.drawable.clear_sky, 24f, "Partly cloudy", 20f, 32f
                ),
                hourlyForecasts = listOf(
                    DayForecast(R.drawable.mainly_clear, 25f, "11:00"),
                    DayForecast(R.drawable.mainly_clear, 25f, "12:00"),
                    DayForecast(R.drawable.mainly_clear, 25f, "01:00"),
                    DayForecast(R.drawable.mainly_clear, 25f, "02:00"),
                ),
                dailyForecasts = listOf(
                    WeekForecast(R.drawable.mainly_clear, "Monday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Tuesday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Wednesday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Thursday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Friday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Saturday", 20f, 32f),
                    WeekForecast(R.drawable.mainly_clear, "Sunday", 20f, 32f),
                )
            )
        }
    }
}