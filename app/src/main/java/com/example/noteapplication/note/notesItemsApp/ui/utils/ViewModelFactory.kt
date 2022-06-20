package com.example.noteapplication.note.notesItemsApp.ui.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapplication.note.notesItemsApp.repository.NoteRepository

class ViewModelFactory (private val repository: NoteRepository)  : ViewModelProvider.NewInstanceFactory(){




    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}