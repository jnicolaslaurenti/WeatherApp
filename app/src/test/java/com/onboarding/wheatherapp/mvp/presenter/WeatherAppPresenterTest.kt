package com.onboarding.wheatherapp.mvp.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import com.nhaarman.mockitokotlin2.whenever
import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.services.WeatherService
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract
import com.onboarding.wheatherapp.mvp.model.WeatherAppModel
import com.onboarding.wheatherapp.mvp.presenter.WeatherAppPresenter.Companion.CITY
import com.onboarding.wheatherapp.util.WeatherTestUtils.date_3
import com.onboarding.wheatherapp.util.WeatherTestUtils.expectedFilteredList
import com.onboarding.wheatherapp.util.WeatherTestUtils.forecastExtendTest
import com.onboarding.wheatherapp.util.WeatherTestUtils.immediate
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test

class WeatherAppPresenterTest {

    private var service: WeatherService = mock()
    private var model = WeatherAppModel(service)
    private var view: WeatherAppContract.View = mock()
    private var presenter: WeatherAppContract.Presenter = WeatherAppPresenter(model, view)
    private var listener: OnForecastListener = mock()

    @Test
    fun `call get five days service success`() {
        whenever(service.getFiveDays(CITY)).thenReturn(Observable.just(forecastExtendTest))
        presenter.getFiveDays(listener)
        verify(view).showProgressBar()
        verify(view).hideProgressBar()
        verify(view).showData(expectedFilteredList, listener)
        verifyZeroInteractions(view)
        Assert.assertEquals(expectedFilteredList, model.getFilteredForecastByDay(date_3))
    }

    @Test
    fun `error in call to get five days service`() {
        whenever(service.getFiveDays(CITY)).thenReturn(Observable.error(Throwable()))
        presenter.getFiveDays(listener)
        verify(view).showProgressBar()
        verify(view).hideProgressBar()
        verify(view).showConnectionProblem()
    }

    @Test
    fun `forecast clicked`() {
        model.saveData(forecastExtendTest)
        presenter.onForecastClicked(date_3)
        verify(view).showForecastDayFragment(expectedFilteredList)
        Assert.assertEquals(expectedFilteredList, model.getFilteredForecastByDay(date_3))
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }
}
