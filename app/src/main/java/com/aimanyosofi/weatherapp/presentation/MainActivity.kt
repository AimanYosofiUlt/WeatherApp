package com.aimanyosofi.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.aimanyosofi.weatherapp.data.repository.WeatherRepositoryImpl
import com.aimanyosofi.weatherapp.presentation.screen.WeatherScreen
import com.aimanyosofi.weatherapp.presentation.view_model.WeatherViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherScreen(viewModel)
        }

        GlobalScope.launch {
            try {
                val weather =
                    WeatherRepositoryImpl(HttpClient(Android)).getWeather(30.0283255, 30.9755904)
                Log.d("ALSKDFJSDLDSDSFS", "onCreate: " + weather)
            } catch (e: Exception) {

            }
        }
    }
}