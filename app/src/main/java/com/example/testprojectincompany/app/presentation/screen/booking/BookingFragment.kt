package com.example.testprojectincompany.app.presentation.screen.booking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.di.DaggerAppComponent
import com.example.testprojectincompany.app.presentation.dialog.ErrorDialog
import com.example.testprojectincompany.app.presentation.screen.booking.composable.AboutClientBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.ButtonBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.DescriptionBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.DetailsDescriptionBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.ListOfTouristsBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.PriceBlock
import com.example.testprojectincompany.app.presentation.screen.booking.composable.ToolBar
import com.example.testprojectincompany.databinding.FragmentBookingBinding
import com.example.testprojectincompany.utils.splitAtIndex
import javax.inject.Inject

class BookingFragment : Fragment() {
    private lateinit var binding: FragmentBookingBinding

    @Inject
    lateinit var viewModelFactory: BookingViewModelFactory
    private lateinit var viewModel: BookingViewModel
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
            .get(BookingViewModel::class.java)

        binding = FragmentBookingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.composeViewEditText.setContent {
            SideEffect {
                Log.e("Booking", "SideEffect")
            }

            val bookingLiveData = viewModel.bookingLiveData.observeAsState()

            val numberTextState = remember { mutableStateOf("") }
            val emailTextState = remember { mutableStateOf("") }

            val numberErrorState = remember { mutableStateOf(false) }
            val emailErrorState = remember { mutableStateOf(false) }

            // Лист туристов
            val listOfTourists = remember {
                mutableStateOf(
                    mutableListOf(
                        TouristModel(
                            position = 0,
                        ),

                        TouristModel(
                            position = 1,
                        ),
                    ),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(state = ScrollState(0)),
            ) {
                ToolBar()
                if (bookingLiveData.value?.code() == 200) {
                    bookingLiveData.value?.body()?.let {
                        DescriptionBlock(
                            rateTextState = stringResource(
                                id = R.string.rate_hotel,
                                it.horating.toString(),
                                it.rating_name,
                            ),
                            nameOfHotelTextState = it.hotel_name,
                            addressOfHotelTextState = it.hotel_adress,
                        )

                        DetailsDescriptionBlock(
                            flightFromTextState = it.departure,
                            cityTextState = it.arrival_country,
                            datesTextState = stringResource(
                                R.string.tour_dates,
                                it.tour_date_start,
                                it.tour_date_stop,
                            ),
                            nightsTextState =
                            if (it.number_of_nights > 4) {
                                stringResource(
                                    R.string.amount_of_nights_when_5,
                                    it.number_of_nights.toString(),
                                )
                            } else {
                                stringResource(
                                    R.string.amount_of_nights_when_2,
                                    it.number_of_nights.toString(),
                                )
                            },
                            roomTextState = it.room,
                            nutritionTextState = it.nutrition,
                            nameOfHotelTextState = it.hotel_name,
                        )
                        AboutClientBlock(
                            emailTextState = emailTextState,
                            numberTextState = numberTextState,
                            emailErrorState = emailErrorState,
                            numberErrorState = numberErrorState,
                        )
                        ListOfTouristsBlock(listOfTourists = listOfTourists)

                        val finalPrice = it.tour_price + it.fuel_charge + it.service_charge

                        PriceBlock(
                            tourTextState = if (it.tour_price.toString().length >= 4) {
                                val priceString = it.tour_price.toString()
                                    .splitAtIndex(it.tour_price.toString().lastIndex - 2)

                                stringResource(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                            } else {
                                stringResource(
                                    R.string.price,
                                    it.tour_price.toString(),
                                )
                            },
                            gasTextState = if (it.fuel_charge.toString().length >= 4) {
                                val priceString = it.fuel_charge.toString()
                                    .splitAtIndex(it.fuel_charge.toString().lastIndex - 2)

                                stringResource(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                            } else {
                                stringResource(
                                    R.string.price,
                                    it.fuel_charge.toString(),
                                )
                            },
                            serviceTextState = if (it.service_charge.toString().length >= 4) {
                                val priceString = it.service_charge.toString()
                                    .splitAtIndex(it.service_charge.toString().lastIndex - 2)

                                stringResource(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                            } else {
                                stringResource(
                                    R.string.price,
                                    it.service_charge.toString(),
                                )
                            },

                            finalPriceTextState = if (finalPrice.toString().length >= 4) {
                                val priceString = finalPrice.toString()
                                    .splitAtIndex(finalPrice.toString().lastIndex - 2)

                                stringResource(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                            } else {
                                stringResource(
                                    R.string.price,
                                    finalPrice.toString(),
                                )
                            },
                        )
                        ButtonBlock(
                            listOfTourists = listOfTourists,
                            navController = findNavController(),
                            btnMakeOrderTextState = if (finalPrice.toString().length >= 4) {
                                val priceString = finalPrice.toString()
                                    .splitAtIndex(finalPrice.toString().lastIndex - 2)

                                stringResource(
                                    R.string.btn_to_pay_for_two,
                                    priceString.first,
                                    priceString.second,
                                )
                            } else {
                                stringResource(
                                    R.string.btn_to_pay,
                                    finalPrice.toString(),
                                )
                            },
                            emailErrorState = emailErrorState,
                            emailTextState = emailTextState,
                            numberTextState = numberTextState,
                            numberErrorState = numberErrorState,
                        )
                    }
                } else {
                    bookingLiveData.value?.message()?.let {
                        ErrorDialog(
                            "Error ${bookingLiveData.value?.code()}",
                            it,
                        ).show(requireActivity().supportFragmentManager, "ErrorDialog")
                    }
                }
            }
        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) { error ->
            ErrorDialog(
                "Some error",
                error,
            ).show(requireActivity().supportFragmentManager, "ErrorDialog")
        }

        viewModel.getBookingData()
    }
}
