package com.onboarding.wheatherapp.data.services.request.generator

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRequestGenerator {

    private val httpClient: OkHttpClient = OkHttpClient.Builder().build()
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL_OPENWEATHER)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S =
        builder.client(httpClient).build().create(serviceClass)

    companion object {
        const val BASE_URL_OPENWEATHER = "http://api.openweathermap.org/data/2.5/"
    }
}
