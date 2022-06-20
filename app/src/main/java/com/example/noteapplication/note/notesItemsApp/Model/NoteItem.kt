// ay data class tt7ad gwa el model .. classes el gwaha el data
package com.example.noteapplication.note.notesItemsApp.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_items")
data class NoteItem (@ColumnInfo(name="item_name")var name:String )// column inside table= entity
 {
  @PrimaryKey(autoGenerate = true)
  var id: Int? = null

}