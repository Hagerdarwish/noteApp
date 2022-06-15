package com.example.noteapplication.note.UTIL

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.databinding.ItemnoteBinding

import com.example.noteapplication.note.MODEL.DCnote



class adapterNOTE(var Notes:List<DCnote>):RecyclerView.Adapter<adapterNOTE.noteViewHolder>() {
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
    }

    override fun getItemCount(): Int {
       return Notes.size
    }
}


