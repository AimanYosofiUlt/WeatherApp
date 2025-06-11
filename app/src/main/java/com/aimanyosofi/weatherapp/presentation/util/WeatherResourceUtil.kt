package com.aimanyosofi.weatherapp.presentation.util

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import com.aimanyosofi.weatherapp.R
import com.aimanyosofi.weatherapp.domain.model.WeatherCode
import com.aimanyosofi.weatherapp.presentation.theme.WeatherColors

object WeatherResourceUtil {
    fun getName(weatherCode: WeatherCode): String {
        return when (weatherCode) {
            WeatherCode.CLEAR_SKY -> "Clear Sky"
            WeatherCode.MAINLY_CLEAR -> "Mainly Clear"
            WeatherCode.PARTLY_CLOUDY -> "Partly Cloudy"
            WeatherCode.OVERCAST -> "Overcast"
            WeatherCode.FOG -> "Fog"
            WeatherCode.DEPOSITING_RIME_FOG -> "Depositing Rime Fog"
            WeatherCode.LIGHT_DRIZZLE -> "Light Drizzle"
            WeatherCode.MODERATE_DRIZZLE -> "Moderate Drizzle"
            WeatherCode.DENSE_INTENSITY_DRIZZLE -> "Dense Intensity Drizzle"
            WeatherCode.LIGHT_FREEZING_DRIZZLE -> "Light Freezing Drizzle"
            WeatherCode.DENSE_INTENSITY_FREEZING_DRIZZLE -> "Dense Intensity Freezing Drizzle"
            WeatherCode.SLIGHT_RAIN_RAIN -> "Slight Rain Rain"
            WeatherCode.MODERATE_RAIN -> "Moderate Rain"
            WeatherCode.HEAVY_INTENSITY_RAIN -> "Heavy Intensity Rain"
            WeatherCode.LIGHT_FREEZING_RAIN -> "Light Freezing Rain"
            WeatherCode.HEAVY_INTENSITY_FREEZING_RAIN -> "Heavy Intensity Freezing Rain"
            WeatherCode.SLIGHT_SNOW_FALL -> "Slight Snow Fall"
            WeatherCode.MODERATE_SNOW_FALL -> "Moderate Snow Fall"
            WeatherCode.HEAVY_INTENSITY_SNOW_FALL -> "Heavy Intensity Snow Fall"
            WeatherCode.SNOW_GRAINS -> "Snow Grains"
            WeatherCode.SLIGHT_RAIN_SHOWERS -> "Slight Rain Showers"
            WeatherCode.MODERATE_RAIN_SHOWERS -> "Moderate Rain Showers"
            WeatherCode.VIOLENT_RAIN_SHOWERS -> "Violent Rain Showers"
            WeatherCode.SLIGHT_SNOW_SHOWERS -> "Slight Snow Showers"
            WeatherCode.HEAVY_SNOW_SHOWERS -> "Heavy Snow Showers"
            WeatherCode.MODERATE_THUNDERSTORM -> "Moderate Thunderstorm"
            WeatherCode.SLIGHT_THUNDERSTORM -> "Slight Thunderstorm"
            WeatherCode.HEAVY_HAIL_THUNDERSTORM -> "Heavy Hail Thunderstorm"
        }
    }

    fun getImageResId(isDay: Boolean, weatherCode: WeatherCode): Int {
        return if (isDay)
            getLightWeatherImage(weatherCode)
        else
            getDarkWeatherImage(weatherCode)
    }

    @DrawableRes
    private fun getLightWeatherImage(weatherCode: WeatherCode): Int {
        return when (weatherCode) {
            WeatherCode.CLEAR_SKY -> R.drawable.clear_sky_light
            WeatherCode.MAINLY_CLEAR -> R.drawable.mainly_clear_light
            WeatherCode.PARTLY_CLOUDY -> R.drawable.group_1_light
            WeatherCode.OVERCAST -> R.drawable.group_4_light
            WeatherCode.FOG -> R.drawable.weather_icon_1_32_light
            WeatherCode.DEPOSITING_RIME_FOG -> R.drawable.weather_icon_1_32_1_light
            WeatherCode.LIGHT_DRIZZLE -> R.drawable.drizzle_light
            WeatherCode.MODERATE_DRIZZLE -> R.drawable.drizzle_moderate_light
            WeatherCode.DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity_light
            WeatherCode.LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_light
            WeatherCode.DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.snow_shower_slight_light
            WeatherCode.SLIGHT_RAIN_RAIN -> R.drawable.rain_slight_light
            WeatherCode.MODERATE_RAIN -> R.drawable.rain_moderate_light
            WeatherCode.HEAVY_INTENSITY_RAIN -> R.drawable.rain_intensity_light
            WeatherCode.LIGHT_FREEZING_RAIN -> R.drawable.weather_icon_1_21_light
            WeatherCode.HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.weather_icon_1_21_1_light
            WeatherCode.SLIGHT_SNOW_FALL -> R.drawable.snow_fall_light_light
            WeatherCode.MODERATE_SNOW_FALL -> R.drawable.snow_fall_moderate_light
            WeatherCode.HEAVY_INTENSITY_SNOW_FALL -> R.drawable.frame_143_light
            WeatherCode.SNOW_GRAINS -> R.drawable.snow_grains_light
            WeatherCode.SLIGHT_RAIN_SHOWERS -> R.drawable.rain_shower_moderate_light
            WeatherCode.MODERATE_RAIN_SHOWERS -> R.drawable.rain_shower_moderate_1_light
            WeatherCode.VIOLENT_RAIN_SHOWERS -> R.drawable.rain_shower_violent_light
            WeatherCode.SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight_light
            WeatherCode.HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy_light
            WeatherCode.MODERATE_THUNDERSTORM -> R.drawable.weather_icon_1_15_light
            WeatherCode.SLIGHT_THUNDERSTORM -> R.drawable.frame_142_light
            WeatherCode.HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail_light
        }
    }

    private fun getDarkWeatherImage(weatherCode: WeatherCode): Int {
        return when (weatherCode) {
            WeatherCode.CLEAR_SKY -> R.drawable.group_14_dark
            WeatherCode.MAINLY_CLEAR -> R.drawable.mainly_clear_dark
            WeatherCode.PARTLY_CLOUDY -> R.drawable.partly_cloudy_dark
            WeatherCode.OVERCAST -> R.drawable.group_4_dark
            WeatherCode.FOG -> R.drawable.weather_icon_1_32_dark
            WeatherCode.DEPOSITING_RIME_FOG -> R.drawable.weather_icon_1_32_1_dark
            WeatherCode.LIGHT_DRIZZLE -> R.drawable.drizzle_light_dark
            WeatherCode.MODERATE_DRIZZLE -> R.drawable.drizzle_moderate_dark
            WeatherCode.DENSE_INTENSITY_DRIZZLE -> R.drawable.drizzle_intensity_dark
            WeatherCode.LIGHT_FREEZING_DRIZZLE -> R.drawable.freezing_drizzle_dark
            WeatherCode.DENSE_INTENSITY_FREEZING_DRIZZLE -> R.drawable.snow_shower_slight_dark
            WeatherCode.SLIGHT_RAIN_RAIN -> R.drawable.weather_icon_1_58_dark
            WeatherCode.MODERATE_RAIN -> R.drawable.weather_icon_1_59_dark
            WeatherCode.HEAVY_INTENSITY_RAIN -> R.drawable.weather_icon_1_60_dark
            WeatherCode.LIGHT_FREEZING_RAIN -> R.drawable.weather_icon_1_21_dark
            WeatherCode.HEAVY_INTENSITY_FREEZING_RAIN -> R.drawable.weather_icon_1_21_1_dark
            WeatherCode.SLIGHT_SNOW_FALL -> R.drawable.weather_icon_1_56_dark
            WeatherCode.MODERATE_SNOW_FALL -> R.drawable.weather_icon_1_57_dark
            WeatherCode.HEAVY_INTENSITY_SNOW_FALL -> R.drawable.frame_143_dark
            WeatherCode.SNOW_GRAINS -> R.drawable.snow_grains_dark
            WeatherCode.SLIGHT_RAIN_SHOWERS -> R.drawable.weather_icon_1_61_dark
            WeatherCode.MODERATE_RAIN_SHOWERS -> R.drawable.weather_icon_1_71_dark
            WeatherCode.VIOLENT_RAIN_SHOWERS -> R.drawable.weather_icon_1_72_dark
            WeatherCode.SLIGHT_SNOW_SHOWERS -> R.drawable.snow_shower_slight_dark
            WeatherCode.HEAVY_SNOW_SHOWERS -> R.drawable.snow_shower_heavy_dark
            WeatherCode.MODERATE_THUNDERSTORM -> R.drawable.weather_icon_1_15_dark
            WeatherCode.SLIGHT_THUNDERSTORM -> R.drawable.frame_142_dark
            WeatherCode.HEAVY_HAIL_THUNDERSTORM -> R.drawable.thunderstrom_with_heavy_hail_dark
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
}
