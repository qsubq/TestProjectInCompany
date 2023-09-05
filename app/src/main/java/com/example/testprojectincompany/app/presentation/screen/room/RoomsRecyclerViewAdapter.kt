package com.example.testprojectincompany.app.presentation.screen.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.presentation.screen.hotel.CloudCardViewItem
import com.example.testprojectincompany.app.presentation.screen.hotel.HotelViewPagerAdapter
import com.example.testprojectincompany.data.remoteDataSource.model.room.Room
import com.example.testprojectincompany.databinding.RoomRecyclerViewLayoutBinding
import com.example.testprojectincompany.utils.splitAtIndex

class RoomsRecyclerViewAdapter() :
    ListAdapter<Room, RoomsRecyclerViewAdapter.RoomViewHolder>(DiffCallback()) {

    private class DiffCallback : DiffUtil.ItemCallback<Room>() {
        override fun areItemsTheSame(oldItem: Room, newItem: Room) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Room, newItem: Room) =
            oldItem == newItem
    }

    class RoomViewHolder(val binding: RoomRecyclerViewLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val binding = RoomRecyclerViewLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        with(holder.binding) {
            val item = currentList[position]

            tvPriceForIt.text = item.price_per
            tvNameOfTheRoom.text = item.name

            btnDetails.setOnClickListener {
                // Ничего не происходит
            }

            btnRoomChoose.setOnClickListener {
                holder.itemView.findNavController()
                    .navigate(R.id.action_roomFragment_to_bookingFragment)
            }

            // Пробел в шестизначных цифрах
            if (item.price.toString().length >= 6) {
                val priceString = item.price.toString()
                    .splitAtIndex(item.price.toString().lastIndex - 2)

                tvPrice.text =
                    holder.itemView.context.getString(
                        R.string.price_for_two_without_from,
                        priceString.first,
                        priceString.second,
                    )
            } else {
                tvPrice.text =
                    holder.itemView.context.getString(
                        R.string.price,
                        item.price.toString(),
                    )
            }

            imgViewPager.adapter = HotelViewPagerAdapter(
                item.image_urls,
            )
            wormDotsIndicator.attachTo(imgViewPager)

            // Динамическое добавление, на случай изменения peculiarities
            for (i in item.peculiarities) {
                val cloudCardViewItem = CloudCardViewItem(
                    holder.itemView.context,
                    i,
                )
                cloudCardViewItem.elevation = 0F
                cloudCardViewItem.cardElevation = 0F
                flexBox.addView(cloudCardViewItem)
            }
        }
    }
}
