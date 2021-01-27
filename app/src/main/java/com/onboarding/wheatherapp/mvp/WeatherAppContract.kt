package com.onboarding.wheatherapp.mvp

import com.onboarding.wheatherapp.data.entity.Weather
import io.reactivex.rxjava3.core.Observable

interface WeatherAppContract {

    interface Model {
        fun getData(city: String): Observable<Weather>
    }

    interface View {
        fun showData(data: Weather)
    }

    interface Presenter {
        fun getFiveDays()
    }
}
