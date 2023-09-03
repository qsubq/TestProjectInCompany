package com.example.testprojectincompany.app.presentation.screen.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.di.DaggerAppComponent
import com.example.testprojectincompany.app.presentation.dialog.ErrorDialog
import com.example.testprojectincompany.databinding.FragmentHotelBinding
import com.example.testprojectincompany.utils.splitAtIndex
import javax.inject.Inject

class HotelFragment : Fragment() {
    private lateinit var binding: FragmentHotelBinding

    @Inject
    lateinit var viewModelFactory: HotelViewModelFactory

    private lateinit var viewModel: HotelViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val component =
            DaggerAppComponent.builder().context(requireContext().applicationContext)
                .build()
        component.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(HotelViewModel::class.java)

        binding = FragmentHotelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.hotelLiveData.observe(viewLifecycleOwner) { response ->
            binding.progressBar.visibility = View.GONE

            if (response.code() == 200) {
                response.body()?.let {
                    with(binding) {
                        imgViewPager.adapter = HotelViewPagerAdapter(
                            it.image_urls,
                        )
                        wormDotsIndicator.attachTo(binding.imgViewPager)

                        tvName.text = it.name
                        tvAddress.text = it.adress
                        tvAboutTheHotel.text = it.about_the_hotel.description
                        tvPriceForIt.text = it.price_for_it

                        tvRate.text = requireContext().getString(
                            R.string.rate_hotel,
                            it.rating.toString(),
                            it.rating_name,
                        )

                        // Пробел в шестизначных цифрах
                        if (it.minimal_price.toString().length >= 6) {
                            val priceString = it.minimal_price.toString()
                                .splitAtIndex(it.minimal_price.toString().length / 2)

                            tvPrice.text =
                                requireContext().getString(
                                    R.string.price_for_two,
                                    priceString.first,
                                    priceString.second,
                                )
                        } else {
                            tvPrice.text =
                                requireContext().getString(
                                    R.string.price,
                                    it.minimal_price.toString(),
                                )
                        }

                        // Динамическое добавление, на случай изменения peculiarities
                        for (i in it.about_the_hotel.peculiarities) {
                            val cloudCardViewItem = CloudCardViewItem(
                                requireContext(),
                                i,
                            )
                            cloudCardViewItem.elevation = 0F
                            cloudCardViewItem.cardElevation = 0F
                            flexBox.addView(cloudCardViewItem)
                        }

                        val bundle = Bundle()
                        bundle.putString("nameOfHotel", it.name)
                        binding.btnRoomChoose.setOnClickListener {
                            findNavController().navigate(
                                R.id.action_hotelFragment_to_roomFragment,
                                bundle,
                            )
                        }
                    }
                }
            } else {
                ErrorDialog(
                    "Error ${response.code()}",
                    response.message(),
                ).show(requireActivity().supportFragmentManager, "ErrorDialog")
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            binding.progressBar.visibility = View.GONE
            ErrorDialog(
                "Some error",
                error,
            ).show(requireActivity().supportFragmentManager, "ErrorDialog")
        }

        getHotelData()
    }

    private fun getHotelData() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getHotelData()
    }
}
