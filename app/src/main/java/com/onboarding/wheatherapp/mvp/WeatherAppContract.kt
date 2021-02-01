package com.onboarding.wheatherapp.mvp

import com.onboarding.wheatherapp.data.entity.Data
import io.reactivex.rxjava3.core.Observable

interface WeatherAppContract {

    interface Model {
        fun getData(city: String): Observable<MutableList<Data>>
    }

    interface View {
        fun showData(data: MutableList<Data>)
        fun showConnectionProblem()
    }

    interface Presenter {
        fun getFiveDays()
    }
}
