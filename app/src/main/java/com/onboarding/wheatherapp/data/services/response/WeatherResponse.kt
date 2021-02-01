package com.onboarding.wheatherapp.data.services.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list") val list: MutableList<DataResponse>
)
