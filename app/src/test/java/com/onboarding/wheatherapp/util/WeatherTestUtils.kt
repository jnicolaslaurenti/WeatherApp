package com.onboarding.wheatherapp.util

import com.onboarding.wheatherapp.data.entity.Data
import com.onboarding.wheatherapp.data.entity.Main
import com.onboarding.wheatherapp.data.entity.WeatherDescription
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import java.util.Observable
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

object WeatherTestUtils {

    const val ZERO = 0
    const val TEMP = "10"
    const val TEMP_MIN = "11"
    const val TEMP_MAX = "12"
    const val ICON_WEATHER_STRING = "HOLA"
    const val date_1 = "10/02/2021 16:39:00"
    const val date_2 = "10/02/2021 17:39:00"
    const val date_3 = "10/02/2021 12:00:00"
    val main = Main(TEMP, TEMP_MIN, TEMP_MAX)
    val weatherDescription = WeatherDescription(ICON_WEATHER_STRING)
    val listWeather: MutableList<WeatherDescription> = mutableListOf(weatherDescription)
    val data_1 = Data(main, listWeather, date_1)
    val data_2 = Data(main, listWeather, date_2)
    val data_3 = Data(main, listWeather, date_3)
    val forecastExtendTest: MutableList<Data> = mutableListOf(data_1, data_2, data_3)
    val expectedFilteredList = listOf<Data>(data_3)

    val immediate = object : Scheduler() {
        override fun scheduleDirect(
            run: Runnable,
            delay: Long,
            unit: TimeUnit
        ): Disposable {
            return super.scheduleDirect(run, ZERO.toLong(), unit)
        }

        override fun createWorker(): Worker {
            return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false, false)
        }
    }
}
