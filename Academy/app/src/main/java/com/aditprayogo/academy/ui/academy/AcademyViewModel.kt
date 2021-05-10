package com.aditprayogo.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aditprayogo.academy.data.source.AcademyRepository
import com.aditprayogo.academy.data.source.local.entity.CourseEntity
import com.aditprayogo.academy.vo.Resource

/**
 * Created by Aditiya Prayogo.
 */
class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<Resource<PagedList<CourseEntity>>> = academyRepository.getAllCourses()

}