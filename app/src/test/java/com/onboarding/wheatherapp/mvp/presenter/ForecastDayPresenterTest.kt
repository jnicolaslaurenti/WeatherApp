package com.onboarding.wheatherapp.mvp.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.onboarding.wheatherapp.mvp.contract.ForecastDayContract
import com.onboarding.wheatherapp.util.WeatherTestUtils.forecastExtendTest
import org.junit.Test

class ForecastDayPresenterTest {

    private var view: ForecastDayContract.View = mock()
    private var presenter: ForecastDayContract.Presenter = ForecastDayPresenter(view)

    @Test
    fun `Show fragment with the weather of the day`() {
        presenter.showForecastDay(forecastExtendTest)
        verify(view).showForecastOfDay(forecastExtendTest)
    }
}
