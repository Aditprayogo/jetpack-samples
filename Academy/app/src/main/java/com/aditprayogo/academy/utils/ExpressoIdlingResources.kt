package com.aditprayogo.academy.utils

import androidx.test.espresso.idling.CountingIdlingResource

/**
 * Created by Aditiya Prayogo.
 */
object EspressoIdlingResource {
    private const val RESOURCE = "GLOBAL"

    val idlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingResource.increment()
    }

    fun decrement() {
        idlingResource.decrement()
    }
}