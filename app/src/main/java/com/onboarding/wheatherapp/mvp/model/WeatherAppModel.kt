package com.onboarding.wheatherapp.mvp.model

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.services.WeatherService
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract
import io.reactivex.rxjava3.core.Observable

class WeatherAppModel(private val weatherService: WeatherService) : WeatherAppContract.Model {
    private lateinit var forecastExtend: List<Data>
    override fun getData(city: String): Observable<MutableList<Data>> =
        weatherService.getFiveDays(city)

    override fun saveData(forecastExtend: List<Data>) {
        this.forecastExtend = forecastExtend
    }

    override fun getFilteredForecastByDay(date: String): List<Data> {
        return forecastExtend.filter { it.date.contains(date) }
    }
}
