package com.onboarding.wheatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.wheatherapp.R
import com.onboarding.wheatherapp.WeatherAdapter
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.WeatherAppContract

class WeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), WeatherAppContract.View {
    override fun showData(data: List<Data>) {
        binding.RecyclerWeather.layoutManager = LinearLayoutManager(context)
        binding.RecyclerWeather.adapter = WeatherAdapter(data)
    }
    override fun showConnectionProblem(){
        Toast.makeText(context, context?.getString(R.string.error), Toast.LENGTH_SHORT).show()
    }
}
