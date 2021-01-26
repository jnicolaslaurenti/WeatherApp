package com.onboarding.wheatherapp.mvp.presenter

import com.onboarding.wheatherapp.mvp.WeatherAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherAppPresenter(
    private val model: WeatherAppContract.Model,
    private val view: WeatherAppContract.View
) : WeatherAppContract.Presenter {


    override fun getFiveDays() {
        model.getData(CITY).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                val aux = data
            }
        view.showData()
    }
    companion object{
        private const val CITY = "Tandil"
    }
}
