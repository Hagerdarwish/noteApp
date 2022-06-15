package com.example.noteapplication.note.UX

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapplication.databinding.ActivityNoteUiBinding
import com.example.noteapplication.note.MODEL.DCnote
import com.example.noteapplication.note.UTIL.adapterNOTE


class noteUI : AppCompatActivity() {
    private lateinit var binding: ActivityNoteUiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteUiBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

        }
    }
}