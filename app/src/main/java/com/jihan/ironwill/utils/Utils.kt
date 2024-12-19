package com.jihan.ironwill.utils

import java.util.Locale

fun Long.toDisplayTime(): String {
    if (this <= 0) {
        return "00:00:00"
    }
    val hours = (this / (1000 * 60 * 60) % 24)
    val minutes = (this / (1000 * 60) % 60)
    val seconds = (this / 1000) % 60

    return String.format(Locale.getDefault(),"%02d:%02d:%02d", hours, minutes, seconds)

}

fun Long.totalDays(): String {

    val days = this / (1000 * 60 * 60 * 24)

    return "$days Days"
}