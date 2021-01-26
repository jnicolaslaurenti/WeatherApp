package com.onboarding.wheatherapp.mvp.model

import com.onboarding.wheatherapp.mvp.WeatherAppContract
import com.onboarding.wheatherapp.services.WeatherService
import com.onboarding.wheatherapp.services.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

class WeatherAppModel(private val weatherService: WeatherService) : WeatherAppContract.Model {

    override fun getData(city: String): Observable<WeatherResponse> =
        weatherService.getFiveDays(city)
}
