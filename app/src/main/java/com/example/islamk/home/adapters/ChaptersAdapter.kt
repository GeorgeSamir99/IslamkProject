package com.example.islamk.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamk.databinding.ItemChapterBinding
import com.example.islamk.home.adapters.callbacks.OnChapterClickListener
import com.example.islamk.home.model.Chapter

class ChaptersAdapter(val chapterList : List<Chapter>): Adapter<ChaptersAdapter.chapterViewHolder>() {
    var onChapterClickListener : OnChapterClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): chapterViewHolder {

        val inflater  = LayoutInflater.from(parent.context)
        val binding = ItemChapterBinding.inflate(inflater , parent , false)
        return chapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  chapterList.size
    }

    override fun onBindViewHolder(holder: chapterViewHolder, position: Int) {
        val item = chapterList[position]
        holder.bind(item ,position)
    }
   inner class chapterViewHolder( val binding : ItemChapterBinding) : ViewHolder(binding.root){

        fun bind(chapter : Chapter ,position : Int){
            binding.chapterOrderTxtView.text = "${chapter.order}"
            binding.chapterTitleEnTextView.text = chapter.titleEn
            binding.chapterTitleArTextView.text = chapter.titleAr
            binding.chapterLengthTextView.text = "${chapter.lengthVerses}  verses"
            binding.root.setOnClickListener{
                onChapterClickListener?.onChapterClicked(chapter,position)
            }
        }

    }
}