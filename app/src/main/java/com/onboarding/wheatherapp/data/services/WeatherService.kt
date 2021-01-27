package com.onboarding.wheatherapp.data.services

import com.onboarding.wheatherapp.data.entity.Weather
import com.onboarding.wheatherapp.data.mapper.WeatherMapper
import com.onboarding.wheatherapp.data.services.api.WeatherApi
import com.onboarding.wheatherapp.data.services.request.generator.WeatherRequestGenerator
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()
    private val mapper = WeatherMapper()

    fun getFiveDays(city: String): Observable<Weather> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getWeather(city, APPID, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.let { subscriber.onNext(mapper.transformWeather(it)) }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val APPID = "90c4a6b89d1036c5fb537a1a3582e818"
        private const val UNITS = "metric"
    }
}
