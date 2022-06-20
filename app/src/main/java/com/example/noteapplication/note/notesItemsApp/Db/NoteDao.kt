package com.example.noteapplication.note.notesItemsApp.Db

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.noteapplication.note.notesItemsApp.Model.NoteItem
@Dao
interface  NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun upsert(item: NoteItem)
    @Delete
    fun delete(item: NoteItem)
    @Query("SELECT*FROM note_items")// el ha3redo fe recycle view" kol 7ata gwa el note_items "
    fun getAllNoteItem(): LiveData<List<NoteItem>>




}