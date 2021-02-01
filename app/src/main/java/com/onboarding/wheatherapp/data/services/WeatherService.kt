package com.onboarding.wheatherapp.data.services

import com.onboarding.wheatherapp.BuildConfig
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.mapper.WeatherMapper
import com.onboarding.wheatherapp.data.services.api.WeatherApi
import com.onboarding.wheatherapp.data.services.request.generator.WeatherRequestGenerator
import io.reactivex.rxjava3.core.Observable

class WeatherService {

    private val api = WeatherRequestGenerator()
    private val mapper = WeatherMapper()

    fun getFiveDays(city: String): Observable<List<Data>> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getWeather(city, BuildConfig.API_KEY, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                response.body()?.list?.filter { it.date.contains(HOUR) }?.let { subscriber.onNext(mapper.transformList(it)) }

            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val UNITS = "metric"
        private const val HOUR = "12:00:00"
    }
}
