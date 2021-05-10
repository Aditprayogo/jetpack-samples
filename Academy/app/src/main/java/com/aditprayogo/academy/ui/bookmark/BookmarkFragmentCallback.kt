package com.aditprayogo.academy.ui.bookmark

import com.aditprayogo.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
