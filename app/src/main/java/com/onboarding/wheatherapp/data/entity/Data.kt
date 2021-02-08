package com.onboarding.wheatherapp.data.entity

data class Data(
    val main: Main,
    val weather: MutableList<WeatherDescription>,
    val date: String
)
