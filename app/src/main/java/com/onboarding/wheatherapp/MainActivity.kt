package com.onboarding.wheatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.services.WeatherService
import com.onboarding.wheatherapp.databinding.ActivityMainBinding
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract
import com.onboarding.wheatherapp.mvp.model.WeatherAppModel
import com.onboarding.wheatherapp.mvp.presenter.WeatherAppPresenter
import com.onboarding.wheatherapp.mvp.view.WeatherAppView

class MainActivity : AppCompatActivity(), OnForecastListener {

    private lateinit var presenter: WeatherAppContract.Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = WeatherAppPresenter(WeatherAppModel(WeatherService()), WeatherAppView(this, binding))
        presenter.getFiveDays(this)
    }

    override fun onForecastClick(date: String) {
        presenter.onForecastClicked(date)
    }
}
