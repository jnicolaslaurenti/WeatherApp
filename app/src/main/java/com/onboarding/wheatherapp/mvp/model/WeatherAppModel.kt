package com.onboarding.wheatherapp.mvp.model

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.services.WeatherService
import com.onboarding.wheatherapp.mvp.WeatherAppContract
import io.reactivex.rxjava3.core.Observable

class WeatherAppModel(private val weatherService: WeatherService) : WeatherAppContract.Model {

    override fun getData(city: String): Observable<MutableList<Data>> =
        weatherService.getFiveDays(city)
}
