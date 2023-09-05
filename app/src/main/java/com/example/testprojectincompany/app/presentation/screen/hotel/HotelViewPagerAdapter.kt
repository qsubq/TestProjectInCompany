package com.example.testprojectincompany.app.presentation.screen.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testprojectincompany.databinding.HotelViewPagerItemLayoutBinding

class HotelViewPagerAdapter(private val listOfImages: List<String>) :
    RecyclerView.Adapter<HotelViewPagerAdapter.HotelViewHolder>() {
    class HotelViewHolder(val binding: HotelViewPagerItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding =
            HotelViewPagerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfImages.size
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listOfImages[position])
            .into(holder.binding.imgHotel)
    }
}
