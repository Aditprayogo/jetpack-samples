package com.aditprayogo.mynotesapproom.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aditprayogo.mynotesapproom.data.local.Note
import com.aditprayogo.mynotesapproom.data.repository.NoteRepository

/**
 * Created by Aditiya Prayogo.
 */
class MainViewModel(application: Application) : ViewModel() {

    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(sort: String): LiveData<PagedList<Note>> {
        return LivePagedListBuilder(mNoteRepository.getAllNotes(sort), 20).build()
    }
}