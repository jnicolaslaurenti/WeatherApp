package com.onboarding.wheatherapp.data.entity


data class Data(
    val main: Main,
    val weather: ArrayList<WeatherDescription>,
    val date: String
)
