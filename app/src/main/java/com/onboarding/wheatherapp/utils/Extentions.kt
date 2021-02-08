package com.onboarding.wheatherapp.utils

fun String.getForecastDate(): String{
    if (StringUtils.START_HOUR < this.length) {
        return this.removeRange(this.length - StringUtils.START_HOUR, this.length)
    }
    return StringUtils.EMPTY_STRING
}

fun String.getForecastHour(): String{
    if (StringUtils.START_HOUR < this.length) {
        return this.removeRange(StringUtils.START_DATE, this.length - StringUtils.START_HOUR)
    }
    return StringUtils.EMPTY_STRING
}