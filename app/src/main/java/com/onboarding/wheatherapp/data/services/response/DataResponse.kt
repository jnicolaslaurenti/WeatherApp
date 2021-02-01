package com.onboarding.wheatherapp.data.services.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("main") val main: MainResponse,
    @SerializedName("weather") val weather: MutableList<WeatherDescriptionResponse>,
    @SerializedName("dt_txt") val date: String
)
