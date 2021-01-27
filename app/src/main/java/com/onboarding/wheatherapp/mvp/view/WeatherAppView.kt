package com.onboarding.wheatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import com.onboarding.wheatherapp.data.entity.Weather
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.WeatherAppContract

class WeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), WeatherAppContract.View {
    override fun showData(data: Weather) {
        Toast.makeText(activity, data.toString(), Toast.LENGTH_SHORT).show()
    }
}
