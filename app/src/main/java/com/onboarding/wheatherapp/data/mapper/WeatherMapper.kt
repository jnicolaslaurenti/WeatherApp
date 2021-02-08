package com.onboarding.wheatherapp.data.mapper

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.entity.Main
import com.onboarding.wheatherapp.data.entity.WeatherDescription
import com.onboarding.wheatherapp.data.services.response.DataResponse
import com.onboarding.wheatherapp.data.services.response.MainResponse
import com.onboarding.wheatherapp.data.services.response.WeatherDescriptionResponse
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherMapper {

    private fun transformMain(main: MainResponse) = Main(main.temp, main.tempMax, main.tempMin)

    private val apiFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    private val appFormat = SimpleDateFormat("EEEE, MM/dd HH:mm", Locale.ENGLISH)

    private fun transformWeatherDescription(weather: MutableList<WeatherDescriptionResponse>): MutableList<WeatherDescription> {
        val weatherData: MutableList<WeatherDescription> = mutableListOf()
        weather.forEach {
            weatherData.add(WeatherDescription(it.iconWeather))
        }
        return weatherData
    }

    fun transformList(list: List<DataResponse>): MutableList<Data> {
        val listData: MutableList<Data> = mutableListOf()
        list.forEach {
            listData.add(
                Data(
                    transformMain(it.main),
                    transformWeatherDescription(it.weather),
                    appFormat.format(apiFormat.parse(it.date) ?: Date())
                )
            )
        }
        return listData
    }
}
