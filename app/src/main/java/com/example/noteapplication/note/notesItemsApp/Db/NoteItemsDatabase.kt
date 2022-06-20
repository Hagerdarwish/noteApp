package com.example.noteapplication.note.notesItemsApp.Db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem
// el class dh no3o database
@Database(
    entities = [NoteItem::class],
    version = 1
)
// ba5od mn class akbar
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

// ybtedy ye7ot fe data base mn a5er makan mawgod
    companion object  {
        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "noteDB.db" //ofline internal data base
            ).build()
    }

}