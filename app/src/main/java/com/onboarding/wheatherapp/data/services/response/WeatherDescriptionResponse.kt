package com.onboarding.wheatherapp.data.services.response

import com.google.gson.annotations.SerializedName

data class WeatherDescriptionResponse(
    @SerializedName("icon") val iconWeather: String
)
