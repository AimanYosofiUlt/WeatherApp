package com.aimanyosofi.weatherapp.domain.model

import io.ktor.http.HttpStatusCode

class NoDataRetrievedException(val status: HttpStatusCode) : Exception("No location retrieved")
class FailedFetchWeatherDataException(status: HttpStatusCode) : Exception(
    "Can't retrieve data from API, response statue: $status"
)