package com.onboarding.wheatherapp.data.entity

import java.io.Serializable

data class Data(
    val main: Main,
    val weather: MutableList<WeatherDescription>,
    val date: String
) : Serializable
