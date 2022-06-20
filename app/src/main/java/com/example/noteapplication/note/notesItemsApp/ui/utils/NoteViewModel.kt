package com.example.noteapplication.note.notesItemsApp.ui.utils

import androidx.lifecycle.ViewModel
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem
import com.example.noteapplication.note.notesItemsApp.repository.NoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel (private val repository: NoteRepository): ViewModel() {


        fun upsert(item: NoteItem) = CoroutineScope(Dispatchers.IO).launch {
            repository.upsert(item)
        }
        fun delete(item: NoteItem) = CoroutineScope(Dispatchers.IO).launch {
            repository.delete(item)
        }
        fun getAllShoppingItems() = repository.getAllNoteItem()
    }
