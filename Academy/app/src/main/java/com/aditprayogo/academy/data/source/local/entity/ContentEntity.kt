package com.aditprayogo.academy.data.source.local.entity

import androidx.room.ColumnInfo

/**
 * Created by Aditiya Prayogo.
 */
data class ContentEntity(
    @ColumnInfo(name = "content")
    var content: String?
)