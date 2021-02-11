package com.onboarding.wheatherapp.mvp.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import com.nhaarman.mockitokotlin2.whenever
import com.onboarding.wheatherapp.data.dialog.OnForecastListener
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.entity.Main
import com.onboarding.wheatherapp.data.entity.WeatherDescription
import com.onboarding.wheatherapp.data.services.WeatherService
import com.onboarding.wheatherapp.mvp.contract.WeatherAppContract
import com.onboarding.wheatherapp.mvp.model.WeatherAppModel
import com.onboarding.wheatherapp.util.WeatherTestUtils.CITY
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
    private var forecastExtendTest = createMutableListTest()
    private var expectedFilteredList = createListTest()



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

        private const val TEMP = "10"
        private const val TEMP_MIN = "11"
        private const val TEMP_MAX = "12"
        private const val ICON_WEATHER_STRING = "HOLA"
        private const val date_1 = "10/02/2021 16:39:00"
        private const val date_2 = "10/02/2021 17:39:00"
        private const val date_3 = "10/02/2021 12:00:00"

        @BeforeClass
        private fun createListTest():List<Data>{
            val main = Main(TEMP, TEMP_MIN, TEMP_MAX)
            val weatherDescription = WeatherDescription(ICON_WEATHER_STRING)
            val listWeather: MutableList<WeatherDescription> = mutableListOf(weatherDescription)
            val data_1 = Data(main, listWeather, date_1)
            val data_2 = Data(main, listWeather, date_2)
            val data_3 = Data(main, listWeather, date_3)
            return listOf<Data>(data_3)
        }

        private fun createMutableListTest():MutableList<Data> {
            val main = Main(TEMP, TEMP_MIN, TEMP_MAX)
            val weatherDescription = WeatherDescription(ICON_WEATHER_STRING)
            val listWeather: MutableList<WeatherDescription> = mutableListOf(weatherDescription)
            val data_1 = Data(main, listWeather, date_1)
            val data_2 = Data(main, listWeather, date_2)
            val data_3 = Data(main, listWeather, date_3)
            return mutableListOf<Data>(data_1, data_2, data_3)
        }

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
