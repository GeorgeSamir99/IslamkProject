package com.example.islamk.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamk.chapterDetails.ChapterDetailsActivity
import com.example.islamk.databinding.FregmentQuranBinding
import com.example.islamk.home.adapters.ChaptersAdapter
import com.example.islamk.home.adapters.callbacks.OnChapterClickListener
import com.example.islamk.home.model.AppConstants
import com.example.islamk.home.model.Chapter

class QuranFragment : Fragment() {
    lateinit var binding: FregmentQuranBinding

    lateinit var adapter : ChaptersAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FregmentQuranBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        adapter = ChaptersAdapter(AppConstants.getChapterList())
        adapter.onChapterClickListener = object :OnChapterClickListener{
            override fun onChapterClicked(chapter: Chapter, position: Int) {
                navigateToQuranDetails(chapter,position)
            }
        }
        binding.chaptersListRecyview.adapter= adapter

    }

    private fun navigateToQuranDetails(chapter: Chapter,position:Int){
           val intent = Intent(activity, ChapterDetailsActivity::class.java)
            intent.putExtra(AppConstants.CHAPTER_KEY,chapter)
            startActivity(intent)
    }
}