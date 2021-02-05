package com.onboarding.wheatherapp.mvp.view

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.wheatherapp.R
import com.onboarding.wheatherapp.WeatherAdapter
import com.onboarding.wheatherapp.data.dialog.ForecastDayFragment
import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract

class WeatherAppView(activity: Activity, private var binding: ActivityMainBinding) :
    ActivityView(activity), WeatherAppContract.View {
    override fun showData(data: List<Data>, onForecastListener: OnForecastListener) {
        binding.RecyclerWeather.layoutManager = LinearLayoutManager(context)
        binding.RecyclerWeather.adapter = WeatherAdapter(data, onForecastListener)
    }

    override fun showConnectionProblem() {
        Toast.makeText(context, context?.getString(R.string.error), Toast.LENGTH_SHORT).show()
    }

    override fun showForecastDayFragment(forecastExtend: List<Data>) {
        ForecastDayFragment.newInstance(ArrayList(forecastExtend))
            .show((context as FragmentActivity).supportFragmentManager, ForecastDayFragment.TAG)
    }
}
