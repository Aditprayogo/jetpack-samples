package com.aditprayogo.mynotesapproom.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.aditprayogo.mynotesapproom.data.local.Note
import com.aditprayogo.mynotesapproom.data.repository.NoteRepository

/**
 * Created by Aditiya Prayogo.
 */
class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)
    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }
}