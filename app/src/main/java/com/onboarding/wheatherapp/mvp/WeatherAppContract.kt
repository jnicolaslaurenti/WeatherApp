package com.onboarding.wheatherapp.mvp

interface WeatherAppContract {

    interface Model {
        fun getData()
    }

    interface View {
        fun showData()
    }

    interface Presenter {
        fun getFiveDays()
    }
}
