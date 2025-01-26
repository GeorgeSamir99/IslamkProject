package com.example.islamk.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamk.databinding.ItemVerseBinding

class VerseAdapter (val versesList : List<String>): Adapter<VerseAdapter.VerseViewHolder>() {

    class VerseViewHolder(val binding : ItemVerseBinding):ViewHolder(binding.root){

        fun binding(verse : String, position : Int){
            binding.verseTextView.text="[ ${position +1} ] $verse"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val binding = ItemVerseBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VerseViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return versesList.size
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val verse = versesList[position]
        holder.binding(verse,position)
    }
}