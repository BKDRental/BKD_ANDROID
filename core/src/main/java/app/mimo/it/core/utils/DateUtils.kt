package app.mimo.it.core.utils

import android.text.format.DateFormat

object DateUtils {

    fun getDay(date: Long): CharSequence = DateFormat.format("dd", date)
    fun getMonth(date: Long): CharSequence = DateFormat.format("MMM", date)
    fun getWeek(date: Long): CharSequence = DateFormat.format("EE", date)
}