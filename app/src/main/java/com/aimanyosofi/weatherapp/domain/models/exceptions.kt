package com.aimanyosofi.weatherapp.domain.models

import io.ktor.http.*

class NoDataRetrievedException(val status: HttpStatusCode) : Exception("No location retrieved")
class NoLocationRetrievedException : Exception("No location retrieved")
class FailedFetchWeatherDataException(status: HttpStatusCode) :
    Exception("Can't retrieve data from API, response statue: $status")