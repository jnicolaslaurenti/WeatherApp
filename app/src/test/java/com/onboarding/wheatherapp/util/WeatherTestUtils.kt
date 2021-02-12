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

    const val CITY = "Tandil"
    const val ZERO = 0

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
