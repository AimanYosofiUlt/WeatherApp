package com.aimanyosofi.weatherapp.presentation.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.formatTo12Hour(format: String): String {
    val inputFormat = SimpleDateFormat(format, Locale.getDefault())
    val outputFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
    val date: Date = inputFormat.parse(this) ?: return ""
    return outputFormat.format(date)
}

fun String.getDayName(format: String): String {
    val inputFormat = SimpleDateFormat(format, Locale.getDefault())
    val outputFormat = SimpleDateFormat("EEEE", Locale.getDefault())
    val date: Date = inputFormat.parse(this) ?: return ""
    return outputFormat.format(date)
}