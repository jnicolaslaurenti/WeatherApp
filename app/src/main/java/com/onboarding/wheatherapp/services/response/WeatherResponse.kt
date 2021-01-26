package com.onboarding.wheatherapp.services.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list")val list: ArrayList<DataResponse>
)
