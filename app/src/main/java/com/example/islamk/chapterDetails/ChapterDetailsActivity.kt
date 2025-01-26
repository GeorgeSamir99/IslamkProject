package com.example.islamk.chapterDetails

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamk.R
import com.example.islamk.databinding.ActivityChapterDetailsBinding
import com.example.islamk.databinding.ActivityHomeBinding
import com.example.islamk.home.adapters.VerseAdapter
import com.example.islamk.home.model.AppConstants
import com.example.islamk.home.model.Chapter

class ChapterDetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityChapterDetailsBinding
    lateinit var adapter : VerseAdapter
     var chapter: Chapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChapterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        receiveParams()
        initRecyclerView()
        binding.backIcon.setOnClickListener {
            finish()
        }
    }

    private fun initRecyclerView() {
        adapter = VerseAdapter(readVerse())
        binding.versesRecyclerView.adapter = adapter
    }

    private fun readVerse(): List<String> {
        val fileContent = assets.open("quran/${chapter?.order}.txt").bufferedReader().use { it.readText() }
         return fileContent.trim().split("\n")

    }

    private fun receiveParams() {
        chapter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY,Chapter::class.java)
        }else{
            intent.getParcelableExtra(AppConstants.CHAPTER_KEY)
        }
        binding.chapterTitleArTextView.text = chapter?.titleAr
        binding.chapterTitleEnTextView.text = chapter?.titleEn
    }
}


