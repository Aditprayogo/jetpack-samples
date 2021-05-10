package com.aditprayogo.academy.ui.reader.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aditprayogo.academy.data.source.AcademyRepository
import com.aditprayogo.academy.data.source.local.entity.ModuleEntity
import com.aditprayogo.academy.vo.Resource

/**
 * Created by Aditiya Prayogo.
 */
class CourseReaderViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    var courseId = MutableLiveData<String>()
    var moduleId = MutableLiveData<String>()

    fun setSelectedCourse(courseId: String) {
        this.courseId.value = courseId
    }

    fun setSelectedModule(moduleId: String) {
        this.moduleId.value = moduleId
    }
    var modules: LiveData<Resource<List<ModuleEntity>>> = Transformations.switchMap(courseId) { mCourseId ->
        academyRepository.getAllModulesByCourse(mCourseId)
    }
    var selectedModule: LiveData<Resource<ModuleEntity>> = Transformations.switchMap(moduleId) { selectedPosition ->
        academyRepository.getContent(selectedPosition)
    }
    fun readContent(module: ModuleEntity) {
        academyRepository.setReadModule(module)
    }
    fun getModuleSize(): Int {
        if (modules.value != null) {
            val moduleEntities = modules.value?.data
            if (moduleEntities != null) {
                return moduleEntities.size
            }
        }
        return 0
    }
    fun setNextPage() {
        if (selectedModule.value != null && modules.value != null) {
            val moduleEntity = selectedModule.value?.data
            val moduleEntities = modules.value?.data
            if (moduleEntity != null && moduleEntities != null) {
                val position = moduleEntity.position
                if (position < moduleEntities.size && position >= 0) {
                    moduleId.value = moduleEntities[position + 1].moduleId
                }
            }
        }
    }
    fun setPrevPage() {
        if (selectedModule.value != null && modules.value != null) {
            val moduleEntity = selectedModule.value?.data
            val moduleEntities = modules.value?.data
            if (moduleEntity != null && moduleEntities != null) {
                val position = moduleEntity.position
                if (position < moduleEntities.size && position >= 0) {
                    moduleId.value = moduleEntities[position - 1].moduleId
                }
            }
        }
    }


}