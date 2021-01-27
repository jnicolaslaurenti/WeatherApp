package com.onboarding.wheatherapp.data.services.response

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("temp") val temp: String,
    @SerializedName("temp_min") val tempMin: String,
    @SerializedName("temp_max") val tempMax: String
)
