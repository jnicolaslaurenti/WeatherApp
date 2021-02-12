package com.onboarding.wheatherapp.mvp.presenter

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.entity.Main
import com.onboarding.wheatherapp.data.entity.WeatherDescription
import com.onboarding.wheatherapp.mvp.contract.ForecastDayContract
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class ForecastDayPresenterTest {

    private var view: ForecastDayContract.View = mock()
    private lateinit var presenter: ForecastDayContract.Presenter
    private lateinit var forecastExtendTest: List<Data>

    @Before
    fun setup() {
        presenter = ForecastDayPresenter(view)
        forecastExtendTest = createListTest()
    }

    @Test
    fun `Show fragment with the weather of the day`() {
        presenter.showForecastDay(forecastExtendTest)
        verify(view).showForecastOfDay(forecastExtendTest)
    }

    companion object {
        private const val TEMP = "10"
        private const val TEMP_MIN = "11"
        private const val TEMP_MAX = "12"
        private const val ICON_WEATHER_STRING = "HOLA"
        private const val date_1 = "10/02/2021 16:39:00"

        @BeforeClass
        fun createListTest(): MutableList<Data> {
            val main = Main(TEMP, TEMP_MIN, TEMP_MAX)
            val weatherDescription = WeatherDescription(ICON_WEATHER_STRING)
            val listWeather: MutableList<WeatherDescription> = mutableListOf(weatherDescription)
            val data = Data(main, listWeather, date_1)
            return mutableListOf(data)
        }
    }
}
