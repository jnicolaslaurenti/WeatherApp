package com.onboarding.wheatherapp.data.mapper

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.entity.Main
import com.onboarding.wheatherapp.data.entity.Weather
import com.onboarding.wheatherapp.data.services.response.DataResponse
import com.onboarding.wheatherapp.data.services.response.MainResponse
import com.onboarding.wheatherapp.data.services.response.WeatherResponse

class WeatherMapper {

    private fun transformMain(main: MainResponse) = Main(main.temp, main.tempMax, main.tempMin)

    private fun transformList(list: ArrayList<DataResponse>): ArrayList<Data> {
        val listData: ArrayList<Data> = arrayListOf()
        list.forEach {
            listData.add(Data(transformMain(it.main)))
        }
        return listData
    }

    fun transformWeather(weatherResponse: WeatherResponse) = Weather(transformList(weatherResponse.list))
}
