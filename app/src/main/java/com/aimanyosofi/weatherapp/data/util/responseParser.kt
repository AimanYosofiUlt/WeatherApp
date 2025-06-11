package com.aimanyosofi.weatherapp.data.util

import com.aimanyosofi.weatherapp.domain.model.NoDataRetrievedException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json
import org.json.JSONObject

suspend inline fun <reified T : Any> retrieve(
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