package com.example.islamk.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamk.databinding.FregmentHadethBinding
import com.example.islamk.home.adapters.HadethAdapter
import com.example.islamk.home.model.Hadeth
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy

class HadethFragment : Fragment() {
    lateinit var binding : FregmentHadethBinding
    lateinit var layoutManager: CarouselLayoutManager
    lateinit var adapter: HadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FregmentHadethBinding.inflate(inflater,container,false)
             return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        layoutManager = CarouselLayoutManager(FullScreenCarouselStrategy(),CarouselLayoutManager.HORIZONTAL)
        layoutManager.carouselAlignment = CarouselLayoutManager.ALIGNMENT_CENTER
        binding.hadethListRecv.layoutManager = layoutManager
        val carouselSnapHelper = CarouselSnapHelper()
        carouselSnapHelper.attachToRecyclerView(binding.hadethListRecv)
        val list = readHadethList()
        adapter = HadethAdapter(list)
        binding.hadethListRecv.adapter = adapter
    }

    private fun readHadethList(): List<Hadeth> {
        val hadethAsString =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethStringList = hadethAsString.trim().split("#")
        return hadethStringList.map {
            val singleHadethSplited = it.trim().split("\n")
            Hadeth(
                hadethTitle = singleHadethSplited[0],
                hadethDescription = singleHadethSplited.subList(1, singleHadethSplited.size)
                    .joinToString()
            )
        }
    }
    }
