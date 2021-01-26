package com.onboarding.wheatherapp.services.api

import com.onboarding.wheatherapp.services.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/forecast")
    fun getWeather(@Query("q") city: String, @Query("appid") appid:String, @Query("units") units:String): Call<WeatherResponse>  //@QueryMap map: HashMap<String, String>): Call<WeatherResponse>
}



