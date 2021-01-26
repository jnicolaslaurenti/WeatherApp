package com.onboarding.wheatherapp.services.api

import com.onboarding.wheatherapp.services.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") appid: String,
        @Query("units") units: String
    ): Call<WeatherResponse>
}
