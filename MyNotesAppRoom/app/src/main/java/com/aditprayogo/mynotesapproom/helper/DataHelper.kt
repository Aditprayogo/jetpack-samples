package com.aditprayogo.mynotesapproom.helper

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Aditiya Prayogo.
 */
object DateHelper {
    fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }
}