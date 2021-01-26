package com.onboarding.wheatherapp.services.response

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("main")val main: MainResponse
)
