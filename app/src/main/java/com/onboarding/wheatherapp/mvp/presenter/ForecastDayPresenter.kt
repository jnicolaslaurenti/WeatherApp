package com.onboarding.wheatherapp.mvp.presenter

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.mvp.contract.ForecastDayContract

class ForecastDayPresenter(private val view: ForecastDayContract.View) : ForecastDayContract.Presenter {

    override fun showForecastDay(forecastExtend: List<Data>) {
        view.showForecastOfDay(forecastExtend)
    }
}
