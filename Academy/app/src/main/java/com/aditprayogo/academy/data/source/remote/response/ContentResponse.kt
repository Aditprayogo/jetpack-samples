package com.aditprayogo.academy.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Aditiya Prayogo.
 */
@Parcelize
data class ContentResponse(
    var moduleId: String,
    var content: String
) : Parcelable