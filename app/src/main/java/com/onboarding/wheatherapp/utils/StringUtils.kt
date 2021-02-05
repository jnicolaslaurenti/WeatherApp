package com.onboarding.wheatherapp.utils

object StringUtils {

    private const val START_HOUR = 5
    private const val START_DATE = 0
    private const val EMPTY_STRING = ""

    fun String.getForecastDate(): String{
        if (START_HOUR < this.length) {
            return this.removeRange(this.length - START_HOUR, this.length)
        }
        return EMPTY_STRING
    }

    fun String.getForecastHour(): String{
        if (START_HOUR < this.length) {
            return this.removeRange(START_DATE, this.length - START_HOUR)
        }
        return EMPTY_STRING
    }
}
