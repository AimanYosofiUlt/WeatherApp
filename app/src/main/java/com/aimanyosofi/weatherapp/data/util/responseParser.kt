package com.aimanyosofi.weatherapp.data.util

import com.aimanyosofi.weatherapp.domain.models.NoDataRetrievedException
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.json.JSONObject

suspend inline fun <reified T : Any> HttpClient.retrieve(
    getApi: String,
    parseJson: (JSONObject) -> String = { it.toString() }
): T {
    return retrieve<T>(get(getApi), parseJson)
}

suspend inline fun <reified T : Any> HttpClient.retrieve(
    httpResponse: HttpResponse,
    parseJson: (JSONObject) -> String = { it.toString() }
): T {
    if (httpResponse.status != HttpStatusCode.OK)
        throw NoDataRetrievedException(httpResponse.status)

    try {
        val jsonObject = JSONObject(httpResponse.bodyAsText())
        val response = parseJson.invoke(jsonObject)
        return response.parseResponse<T>()
    } catch (e: Exception) {
        throw NoDataRetrievedException(httpResponse.status)
    }
}

inline fun <reified T : Any> String.parseResponse(): T {
    val json = Json {
        ignoreUnknownKeys = true
    }
    return json.decodeFromString<T>(this)
}