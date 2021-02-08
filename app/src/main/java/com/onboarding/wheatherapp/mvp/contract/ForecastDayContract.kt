package com.onboarding.wheatherapp.mvp.contract

import com.onboarding.wheatherapp.data.entity.Data

interface ForecastDayContract {

    interface View {
        fun showForecastOfDay(forecastExtend: List<Data>)
    }

    interface Presenter {
        fun showForecastDay(forecastExtend: List<Data>)
    }
}
