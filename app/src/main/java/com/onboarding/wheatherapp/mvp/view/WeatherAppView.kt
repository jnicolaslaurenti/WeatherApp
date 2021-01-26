package com.onboarding.wheatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import com.onboarding.wheatherapp.R
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.WeatherAppContract
import com.onboarding.wheatherapp.services.response.WeatherResponse

class WeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), WeatherAppContract.View {
    override fun showData(data: WeatherResponse) {
        Toast.makeText(activity, data.toString(), Toast.LENGTH_SHORT).show()
    }
}
