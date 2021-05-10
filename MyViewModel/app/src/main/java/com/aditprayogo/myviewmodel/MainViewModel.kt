package com.aditprayogo.myviewmodel

import androidx.lifecycle.ViewModel

/**
 * Created by Aditiya Prayogo.
 */
class MainViewModel : ViewModel() {

    var result = 0

    fun calculate(width: String, height: String, length: String) {
        result = width.toInt() * height.toInt() * length.toInt()
    }

}