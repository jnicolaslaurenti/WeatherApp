package com.onboarding.wheatherapp.mvp.presenter

import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherAppPresenter(
    private val model: WeatherAppContract.Model,
    private val view: WeatherAppContract.View
) : WeatherAppContract.Presenter {

    override fun getFiveDays(onForecastListener: OnForecastListener) {
        view.showProgressBar()
        model.getData(CITY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                model.saveData(data)
                view.hideProgressBar()
                view.showData(model.getFilteredForecastByDay(HOUR), onForecastListener)
            }, {
                view.hideProgressBar()
                view.showConnectionProblem()
            })
    }

    override fun onForecastClicked(date: String) {
        view.showForecastDayFragment(model.getFilteredForecastByDay(date))
    }

    companion object {
        const val CITY = "Tandil"
        const val HOUR = "12:00"
    }
}
