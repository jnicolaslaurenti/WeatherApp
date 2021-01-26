package com.onboarding.wheatherapp.mvp

import com.onboarding.wheatherapp.services.response.WeatherResponse
import io.reactivex.rxjava3.core.Observable

interface WeatherAppContract {

    interface Model {
        fun getData(city: String): Observable<WeatherResponse>
    }

    interface View {
        fun showData()
    }

    interface Presenter {
        fun getFiveDays()
    }
}
