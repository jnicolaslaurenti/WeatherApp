package com.onboarding.wheatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import com.onboarding.wheatherapp.R
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.WeatherAppContract

class WeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), WeatherAppContract.View {
    override fun showData() {
        Toast.makeText(activity, R.string.connection_success, Toast.LENGTH_SHORT).show()
    }
}
