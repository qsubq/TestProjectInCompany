package com.example.testprojectincompany.presentation.screen.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testprojectincompany.R
import com.example.testprojectincompany.databinding.FragmentHotelBinding

class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding
    private val viewModel by viewModels<HotelViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.hotelLiveData.observe(viewLifecycleOwner) { response ->
            if (response.code() == 200) {
                with(binding) {
                    tvName.text = response.body()?.name
                    tvRate.text = requireContext().getString(
                        R.string.rate_hotel,
                        response.body()?.rating.toString(),
                        response.body()?.rating_name,
                    )
                    tvPrice.text =
                        requireContext().getString(R.string.price, response.body()?.minimal_price.toString())
                    tvAddress.text = response.body()?.adress
                    tvAboutTheHotel.text = response.body()?.about_the_hotel?.description
                    tvPriceForIt.text = response.body()?.price_for_it
                    imgViewPager.adapter = response.body()?.image_urls?.let {
                        HotelViewPagerAdapter(
                            it
                        )
                    }

                    binding.wormDotsIndicator.attachTo(binding.imgViewPager)
                }
            }
        }

        viewModel.getHotelData()
    }
}
