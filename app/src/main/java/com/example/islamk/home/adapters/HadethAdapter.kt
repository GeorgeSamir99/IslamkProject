package com.example.islamk.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamk.databinding.ItemHadethBinding
import com.example.islamk.home.model.Hadeth

class HadethAdapter(val hadethList:List<Hadeth>) : Adapter<HadethAdapter.HadethViewHold>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHold {

       // val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHadethBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return HadethViewHold(binding)

    }

    override fun getItemCount(): Int {
        return hadethList.size
    }

    override fun onBindViewHolder(holder: HadethViewHold, position: Int) {
        val item = hadethList[position]
        holder.bind(item)

    }


    class HadethViewHold(val binding: ItemHadethBinding):ViewHolder(binding.root){

        fun bind(hadeth : Hadeth){
            binding.hadethTitle.text = hadeth.hadethTitle
            binding.hadethDescription.text = hadeth.hadethDescription
        }

    }


}