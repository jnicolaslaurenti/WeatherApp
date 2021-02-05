package com.onboarding.wheatherapp.mvp.contract

import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.entity.Data
import io.reactivex.rxjava3.core.Observable

interface WeatherAppContract {

    interface Model {
        fun getData(city: String): Observable<MutableList<Data>>
        fun saveData(forecastExtend: List<Data>)
        fun getFilteredForecastByDay(date: String): List<Data>
    }

    interface View {
        fun showData(data: List<Data>, onForecastListener: OnForecastListener)
        fun showConnectionProblem()
        fun showForecastDayFragment(forecastExtend: List<Data>)
    }

    interface Presenter {
        fun getFiveDays(onForecastListener: OnForecastListener)
        fun onForecastClicked(date: String)
    }
}
