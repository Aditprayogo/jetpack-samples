package com.aditprayogo.academy.di

import android.content.Context
import com.aditprayogo.academy.data.source.AcademyRepository
import com.aditprayogo.academy.data.source.local.LocalDataSource
import com.aditprayogo.academy.data.source.local.room.AcademyDatabase
import com.aditprayogo.academy.data.source.remote.RemoteDataSource
import com.aditprayogo.academy.utils.AppExecutors
import com.aditprayogo.academy.utils.JsonHelper

/**
 * Created by Aditiya Prayogo.
 */
object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}