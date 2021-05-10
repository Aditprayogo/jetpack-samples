package com.aditprayogo.academy.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created by Aditiya Prayogo.
 */
data class CourseWithModule (
    @Embedded
    var mCourse: CourseEntity,

    @Relation(parentColumn = "courseId", entityColumn = "courseId")
    var mModules: List<ModuleEntity>
)