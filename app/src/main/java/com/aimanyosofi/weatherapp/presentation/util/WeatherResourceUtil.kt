package com.aimanyosofi.weatherapp.presentation.util

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors

object WeatherResourceUtil {
    fun getName(weatherCode: Int): String {
        return when (weatherCode) {
            CLEAR_SKY -> "Clear Sky"
            MAINLY_CLEAR -> "Mainly Clear"
            PARTLY_CLOUDY -> "Partly Cloudy"
            OVERCAST -> "Overcast"
            FOG -> "Fog"
            DEPOSITING_RIME_FOG -> "Depositing Rime Fog"
            LIGHT_DRIZZLE -> "Light Drizzle"
            MODERATE_DRIZZLE -> "Moderate Drizzle"
            DENSE_INTENSITY_DRIZZLE -> "Dense Intensity Drizzle"
            LIGHT_FREEZING_DRIZZLE -> "Light Freezing Drizzle"
            DENSE_INTENSITY_FREEZING_DRIZZLE -> "Dense Intensity Freezing Drizzle"
            SLIGHT_RAIN_RAIN -> "Slight Rain Rain"
            MODERATE_RAIN -> "Moderate Rain"
            HEAVY_INTENSITY_RAIN -> "Heavy Intensity Rain"
            LIGHT_FREEZING_RAIN -> "Light Freezing Rain"
            HEAVY_INTENSITY_FREEZING_RAIN -> "Heavy Intensity Freezing Rain"
            SLIGHT_SNOW_FALL -> "Slight Snow Fall"
            MODERATE_SNOW_FALL -> "Moderate Snow Fall"
            HEAVY_INTENSITY_SNOW_FALL -> "Heavy Intensity Snow Fall"
            SNOW_GRAINS -> "Snow Grains"
            SLIGHT_RAIN_SHOWERS -> "Slight Rain Showers"
            MODERATE_RAIN_SHOWERS -> "Moderate Rain Showers"
            VIOLENT_RAIN_SHOWERS -> "Violent Rain Showers"
            SLIGHT_SNOW_SHOWERS -> "Slight Snow Showers"
            HEAVY_SNOW_SHOWERS -> "Heavy Snow Showers"
            MODERATE_THUNDERSTORM -> "Moderate Thunderstorm"
            SLIGHT_THUNDERSTORM -> "Slight Thunderstorm"
            HEAVY_HAIL_THUNDERSTORM -> "Heavy Hail Thunderstorm"
            else -> "Unknown"
        }
    }

    fun getImageResId(isDay: Boolean, weatherCode: Int): Int {
        return if (isDay)
            getLightWeatherImage(weatherCode)
        else
            getDarkWeatherImage(weatherCode)
    }

    @DrawableRes
    private fun getLightWeatherImage(weatherCode: Int): Int {
        return when (weatherCode) {
            CLEAR_SKY -> R.drawable.clear_sky_light
            MAINLY_CLEAR -> R.drawable.mainly_clear_light
            PARTLY_CLOUDY -> R.drawable.group_1_light
            OVERCAST -> R.drawable.group_4_light
            FOG -> R.drawable.weather_icon_1_32_light
            DEPOSITING_RIME_FOG -> R.drawable.weather_icon_1_32_1_light
            LIGHT_DRIZZLE -> R.drawable.drizzle_light
            MODERATE_DRIZZLE -> R.drawable.drizzle_moderate_light
            DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity_light
            LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_light
            DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.snow_shower_slight_light
            SLIGHT_RAIN_RAIN -> R.drawable.rain_slight_light
            MODERATE_RAIN -> R.drawable.rain_moderate_light
            HEAVY_INTENSITY_RAIN -> R.drawable.rain_intensity_light
            LIGHT_FREEZING_RAIN -> R.drawable.weather_icon_1_21_light
            HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.weather_icon_1_21_1_light
            SLIGHT_SNOW_FALL -> R.drawable.snow_fall_light_light
            MODERATE_SNOW_FALL -> R.drawable.snow_fall_moderate_light
            HEAVY_INTENSITY_SNOW_FALL -> R.drawable.frame_143_light
            SNOW_GRAINS -> R.drawable.snow_grains_light
            SLIGHT_RAIN_SHOWERS -> R.drawable.rain_shower_moderate_light
            MODERATE_RAIN_SHOWERS -> R.drawable.rain_shower_moderate_1_light
            VIOLENT_RAIN_SHOWERS -> R.drawable.rain_shower_violent_light
            SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight_light
            HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy_light
            MODERATE_THUNDERSTORM -> R.drawable.weather_icon_1_15_light
            SLIGHT_THUNDERSTORM -> R.drawable.frame_142_light
            HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail_light
            else -> R.drawable.forcast_test
        }
    }

    private fun getDarkWeatherImage(weatherCode: Int): Int {
        return when (weatherCode) {
            CLEAR_SKY -> R.drawable.group_14_dark
            MAINLY_CLEAR -> R.drawable.mainly_clear_dark
            PARTLY_CLOUDY -> R.drawable.partly_cloudy_dark
            OVERCAST -> R.drawable.group_4_dark
            FOG -> R.drawable.weather_icon_1_32_dark
            DEPOSITING_RIME_FOG -> R.drawable.weather_icon_1_32_1_dark
            LIGHT_DRIZZLE -> R.drawable.drizzle_light_dark
            MODERATE_DRIZZLE -> R.drawable.drizzle_moderate_dark
            DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity_dark
            LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_dark
            DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.snow_shower_slight_dark
            SLIGHT_RAIN_RAIN -> R.drawable.weather_icon_1_58_dark
            MODERATE_RAIN -> R.drawable.weather_icon_1_59_dark
            HEAVY_INTENSITY_RAIN -> R.drawable.weather_icon_1_60_dark
            LIGHT_FREEZING_RAIN -> R.drawable.weather_icon_1_21_dark
            HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.weather_icon_1_21_1_dark
            SLIGHT_SNOW_FALL -> R.drawable.weather_icon_1_56_dark
            MODERATE_SNOW_FALL -> R.drawable.weather_icon_1_57_dark
            HEAVY_INTENSITY_SNOW_FALL -> R.drawable.frame_143_dark
            SNOW_GRAINS -> R.drawable.snow_grains_dark
            SLIGHT_RAIN_SHOWERS -> R.drawable.weather_icon_1_61_dark
            MODERATE_RAIN_SHOWERS -> R.drawable.weather_icon_1_71_dark
            VIOLENT_RAIN_SHOWERS -> R.drawable.weather_icon_1_72_dark
            SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight_dark
            HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy_dark
            MODERATE_THUNDERSTORM -> R.drawable.weather_icon_1_15_dark
            SLIGHT_THUNDERSTORM -> R.drawable.frame_142_dark
            HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail_dark
            else -> R.drawable.forcast_test
        }
    }

    @Composable
    fun getBackgroundColor(): Brush {
        return Brush.linearGradient(
            listOf(
                WeatherColors.primaryToBlack,
                WeatherColors.primaryToBlack,
                WeatherColors.whiteToBlack,
                WeatherColors.whiteToBlack
            )
        )
    }


    private const val CLEAR_SKY = 0
    private const val MAINLY_CLEAR = 1
    private const val PARTLY_CLOUDY = 2
    private const val OVERCAST = 3
    private const val FOG = 45
    private const val DEPOSITING_RIME_FOG = 48
    private const val LIGHT_DRIZZLE = 51
    private const val MODERATE_DRIZZLE = 53
    private const val DENSE_INTENSITY_DRIZZLE = 55
    private const val LIGHT_FREEZING_DRIZZLE = 56
    private const val DENSE_INTENSITY_FREEZING_DRIZZLE = 57
    private const val SLIGHT_RAIN_RAIN = 61
    private const val MODERATE_RAIN = 63
    private const val HEAVY_INTENSITY_RAIN = 65
    private const val LIGHT_FREEZING_RAIN = 66
    private const val HEAVY_INTENSITY_FREEZING_RAIN = 67
    private const val SLIGHT_SNOW_FALL = 71
    private const val MODERATE_SNOW_FALL = 73
    private const val HEAVY_INTENSITY_SNOW_FALL = 75
    private const val SNOW_GRAINS = 77
    private const val SLIGHT_RAIN_SHOWERS = 80
    private const val MODERATE_RAIN_SHOWERS = 81
    private const val VIOLENT_RAIN_SHOWERS = 82
    private const val SLIGHT_SNOW_SHOWERS = 85
    private const val HEAVY_SNOW_SHOWERS = 86
    private const val MODERATE_THUNDERSTORM = 95
    private const val SLIGHT_THUNDERSTORM = 96
    private const val HEAVY_HAIL_THUNDERSTORM = 99
}
