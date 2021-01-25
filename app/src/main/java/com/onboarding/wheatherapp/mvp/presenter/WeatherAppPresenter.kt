package com.onboarding.wheatherapp.mvp.presenter

import com.onboarding.wheatherapp.mvp.WeatherAppContract

class WeatherAppPresenter(
    private val model: WeatherAppContract.Model,
    private val view: WeatherAppContract.View
) : WeatherAppContract.Presenter {

    override fun getFiveDays() {
        model.getData()
        view.showData()
    }
}
