package com.example.noteapplication.note.notesItemsApp.repository

import com.example.noteapplication.note.notesItemsApp.Db.NoteDatabase
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem

class NoteRepository (private val db:NoteDatabase){


        fun upsert(item: NoteItem) = db.getNoteDao().upsert(item)

        fun delete (item: NoteItem) = db.getNoteDao().delete(item)

        fun getAllNoteItem() = db.getNoteDao().getAllNoteItem()

    }