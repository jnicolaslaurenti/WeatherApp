package com.onboarding.wheatherapp.services

import com.onboarding.wheatherapp.services.api.WeatherApi
import com.onboarding.wheatherapp.services.request.generator.WeatherRequestGenerator
import com.onboarding.wheatherapp.services.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable


class WeatherService {

    private val api = WeatherRequestGenerator()

    fun getFiveDays(city: String): Observable<WeatherResponse> {
        return Observable.create{subscriber ->
            val callResponse = api.createService(WeatherApi::class.java).getWeather(city, APPID, UNITS)
            val response = callResponse.execute()
            if (response.isSuccessful){
                response.body()?.list.let { subscriber.onComplete() }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
    companion object{
        private const val APPID = "90c4a6b89d1036c5fb537a1a3582e818"
        private const val UNITS = "metric"
    }
}
