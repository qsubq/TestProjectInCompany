package com.example.testprojectincompany.presentation.screen.hotel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testprojectincompany.databinding.HotelViewPagerItemBinding
import com.squareup.picasso.Picasso

class HotelViewPagerAdapter(private val listOfImages: List<String>) :
    RecyclerView.Adapter<HotelViewPagerAdapter.HotelViewHolder>() {
    class HotelViewHolder(val binding: HotelViewPagerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding =
            HotelViewPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfImages.size
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        Picasso.get().load(listOfImages[position]).into(holder.binding.imgHotel)
    }
}
