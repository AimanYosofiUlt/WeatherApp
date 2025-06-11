package com.aimanyosofi.weatherapp.data.repository

import com.aimanyosofi.weatherapp.data.mapper.toDomain
import com.aimanyosofi.weatherapp.data.model.WeatherDto
import com.aimanyosofi.weatherapp.data.util.retrieve
import com.aimanyosofi.weatherapp.domain.model.FailedFetchWeatherDataException
import com.aimanyosofi.weatherapp.domain.model.NoDataRetrievedException
import com.aimanyosofi.weatherapp.domain.model.Weather
import com.aimanyosofi.weatherapp.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

const val OPEN_METO_API = "https://api.open-meteo.com/v1/forecast"

class WeatherRepositoryImpl(private val httpClient: HttpClient) : WeatherRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double): Weather {
        val httpResponse: HttpResponse = httpClient.get(OPEN_METO_API) {
            parameter("latitude", latitude)
            parameter("longitude", longitude)
            parameter(
                "daily",
                "temperature_2m_max,temperature_2m_min,uv_index_max,weather_code"
            )
            parameter(
                "hourly",
                "temperature_2m,weather_code"
            )
            parameter(
                "current",
                "weather_code,relative_humidity_2m,wind_speed_10m,rain,surface_pressure,apparent_temperature,temperature_2m,is_day"
            )
        }

        try {
            return retrieve<WeatherDto>(httpResponse) { jsonData ->
                jsonData.toString()
            }.toDomain()
        } catch (e: NoDataRetrievedException) {
            throw FailedFetchWeatherDataException(e.status)
        }
    }
}
