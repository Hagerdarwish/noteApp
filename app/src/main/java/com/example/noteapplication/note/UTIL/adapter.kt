package com.example.noteapplication.note.UTIL

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.databinding.ItemnoteBinding
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem
import com.example.noteapplication.note.notesItemsApp.ui.utils.NoteViewModel

/*import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.databinding.ItemnoteBinding

import com.example.noteapplication.note.MODEL.DCnote
import com.example.noteapplication.note.notesItemsApp.Model.NoteItem


class adapterNOTE(var Notes:List<NoteItem>):RecyclerView.Adapter<adapterNOTE.noteViewHolder>() {
    inner class noteViewHolder(val binding: ItemnoteBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {

        return noteViewHolder(ItemnoteBinding.inflate(LayoutInflater.from(parent.context ),parent, false) )//return el desgin .. el context by3ml
                                                                                                                                        // return lek l kol 7aga 7ala fe class bata3y
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        // return el position leya
       holder.binding.apply {
           tvitems.text = Notes[position].title

       }
    }*/
    class NoteItemAdapter (var items:List<NoteItem>, private val viewModel: NoteViewModel) : RecyclerView.Adapter<NoteItemAdapter.noteViewHolder>() {

    inner class noteViewHolder(val binding: ItemnoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteViewHolder {
        return noteViewHolder(ItemnoteBinding.inflate(LayoutInflater.from(parent.context ),parent, false) )
    }

    override fun onBindViewHolder(holder: noteViewHolder, position: Int) {
        var currentNoteItem = items[position]
        holder.binding.tvitems.text = currentNoteItem.name
        holder.binding.noteItemDelete.setOnClickListener {
            viewModel.delete(currentNoteItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}





