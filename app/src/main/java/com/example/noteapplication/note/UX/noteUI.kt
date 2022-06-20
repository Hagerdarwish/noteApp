package com.example.noteapplication.note.UX

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.databinding.ActivityNoteUiBinding
import com.example.noteapplication.note.UTIL.NoteItemAdapter
import com.example.noteapplication.note.notesItemsApp.Db.NoteDatabase
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem
import com.example.noteapplication.note.notesItemsApp.repository.NoteRepository
import com.example.noteapplication.note.notesItemsApp.ui.utils.AddDialogListener
import com.example.noteapplication.note.notesItemsApp.ui.utils.NoteViewModel
import com.example.noteapplication.note.notesItemsApp.ui.utils.ViewModelFactory

/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.databinding.ActivityNoteUiBinding
import com.example.noteapplication.note.MODEL.DCnote
import com.example.noteapplication.note.UTIL.adapterNOTE*/


class noteUI (context: Context, var addDialogListener: AddDialogListener) : AppCompatActivity() {
    private lateinit var binding: ActivityNoteUiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteUiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val view =ViewModelProviders.of(this)

        binding.btnAddText.setOnClickListener { /* 1-lma ados 3ala btn -- 2-a7wel el et le string w adwdeha lel data  */
            var NoteItemName= binding.etAddText.text.toString()

            var item = NoteItem(NoteItemName)
            addDialogListener.onAddButtonClicked(item)

        }

                val database = NoteDatabase(this)
                val repository = NoteRepository(database)
                val factory = ViewModelFactory(repository)

                val viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java) // MANDATORY

                val NoteItemAdapter = NoteItemAdapter(listOf(), viewModel)
                binding.rvNote.layoutManager = LinearLayoutManager(this)
                binding.rvNote.adapter = NoteItemAdapter

                viewModel.getAllShoppingItems().observe( this, Observer {
                    NoteItemAdapter.items=it
                    NoteItemAdapter.notifyDataSetChanged()

                })


        /*
        val noteList= mutableListOf( DCnote("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."))
        val adapter=adapterNOTE(noteList)
        binding.rvNote.adapter= adapter
        binding.rvNote.layoutManager=LinearLayoutManager(this
        )
        binding.btnAddText.setOnClickListener { /* 1-lma ados 3ala btn -- 2-a7wel el et le string w adwdeha lel data  */
            var newTitle= binding.etAddText.text.toString()
           var newNote= DCnote(newTitle)
            noteList.add(DCnote(newTitle))
            adapter.notifyDataSetChanged()
            binding.etAddText.text.clear()

        }*/
    }
}