package com.onboarding.wheatherapp.mvp.view

import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.onboarding.wheatherapp.WeatherAdapter
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.databinding.WeatherDialogBinding
import com.onboarding.wheatherapp.mvp.contract.ForecastDayContract
import com.onboarding.wheatherapp.utils.getForecastDate

class ForecastDayView(fragment: DialogFragment, private val binding: WeatherDialogBinding) : FragmentView(fragment),
    ForecastDayContract.View {

    override fun showForecastOfDay(forecastExtend: List<Data>) {
        val date = forecastExtend.first().date
        binding.fragmentTitle.text = date.getForecastDate()
        binding.recyclerFragment.layoutManager = LinearLayoutManager(context)
        binding.recyclerFragment.adapter = WeatherAdapter(forecastExtend)
    }

}
