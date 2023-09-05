package com.example.testprojectincompany.app.presentation.screen.booking

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testprojectincompany.R
import com.example.testprojectincompany.app.di.DaggerAppComponent
import com.example.testprojectincompany.app.presentation.dialog.ErrorDialog
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

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val numberTextState = mutableStateOf("")
        val emailTextState = mutableStateOf("")

        val numberErrorState = mutableStateOf(false)
        val emailErrorState = mutableStateOf(false)

        binding.composeViewEditText.setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                PhoneField(
                    phone = numberTextState.value,
                    errorState = numberErrorState,
                    mask = "+7 (***) ***-**-**",
                    maskNumber = '*',
                    onPhoneChanged = { numberTextState.value = it },
                )

                TextField(
                    modifier = Modifier
                        .border(width = 0.dp, color = Color.White)
                        .padding(top = 8.dp, bottom = 8.dp)
                        .fillMaxWidth(),
                    value = emailTextState.value,
                    onValueChange = { it ->
                        if (it.isNotEmpty()) {
                            emailErrorState.value = false
                        }

                        emailTextState.value = it

                        emailErrorState.value = !Patterns.EMAIL_ADDRESS
                            .matcher(emailTextState.value)
                            .matches()
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                    isError = emailErrorState.value,
                    placeholder = {
                        Text("examplemail.000@mail.ru", color = Color(0xFF14142B), fontSize = 16.sp)
                    },
                    label = {
                        Text(text = "Почта", color = Color(0xFFA9ABB7), fontSize = 17.sp)
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color(0xFFF6F6F9),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = colorResource(id = R.color.error_red),
                    ),
                    shape = RoundedCornerShape(size = 10.dp),
                )

                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "Эти данные никому не передаются. После оплаты мы\nвышли чек на указанный вами номер и почту",
                    color = colorResource(
                        id = R.color.grey_200,
                    ),
                    fontSize = 14.sp,
                    style = TextStyle(lineHeight = 16.8.sp),
                )
            }
        }

        binding.composeViewLazyColumn.setContent {
            Column(modifier = Modifier.fillMaxWidth()) {
                LazyColumn {
                    items(2) {
                        val isCollapsedState = remember { mutableStateOf(false) }
                        val nameTextState = remember { mutableStateOf("") }

                        Card(
                            modifier = Modifier.padding(bottom = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        top = 13.dp,
                                        start = 16.dp,
                                        end = 16.dp,
                                        bottom = 13.dp,
                                    ),
                            ) {
                                Text(
                                    text = "Первый турист",
                                    fontSize = 22.sp,
                                    color = Color.Black,
                                    style = TextStyle(lineHeight = 26.4.sp),
                                    fontWeight = FontWeight.Medium,
                                )
                                Image(
                                    modifier = Modifier
                                        .align(Alignment.CenterEnd)
                                        .padding(top = 3.dp)
                                        .clickable {
                                            isCollapsedState.value = !isCollapsedState.value
                                        },
                                    imageVector = if (isCollapsedState.value) {
                                        ImageVector.vectorResource(id = R.drawable.arrow_to_the_downsvg)
                                    } else {
                                        ImageVector.vectorResource(id = R.drawable.arrow_to_the_up)
                                    },
                                    contentDescription = null,
                                )
                            }

                            if (!isCollapsedState.value) {
                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(top = 3.dp, start = 16.dp, end = 16.dp)
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Имя",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )

                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Фамилия",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )
                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Дата рождения",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )
                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Гражданство",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )
                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Номер загранпаспорта",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )
                                TextField(
                                    modifier = Modifier
                                        .border(width = 0.dp, color = Color.White)
                                        .padding(
                                            top = 8.dp,
                                            start = 16.dp,
                                            end = 16.dp,
                                            bottom = 16.dp,
                                        )
                                        .fillMaxWidth(),
                                    value = nameTextState.value,
                                    onValueChange = { it ->
                                        nameTextState.value = it
                                    },
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                                    label = {
                                        Text(
                                            text = "Срок действия загранпаспорта",
                                            color = Color(0xFFA9ABB7),
                                            fontSize = 17.sp,
                                        )
                                    },
                                    colors = TextFieldDefaults.textFieldColors(
                                        containerColor = Color(0xFFF6F6F9),
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent,
                                    ),
                                    shape = RoundedCornerShape(size = 10.dp),
                                )
                            }
                        }
                    }
                }

                Card(
                    modifier = Modifier.padding(top = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 13.dp, start = 16.dp, end = 16.dp, bottom = 13.dp),
                    ) {
                        Text(
                            text = "Добавить туриста",
                            fontSize = 22.sp,
                            color = Color.Black,
                            style = TextStyle(lineHeight = 26.4.sp),
                            fontWeight = FontWeight.Medium,
                        )
                        Image(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .clickable {
                                },
                            imageVector = ImageVector.vectorResource(id = R.drawable.plus_btn_icon),
                            contentDescription = null,
                        )
                    }
                }
            }
        }

        viewModel.bookingLiveData.observe(viewLifecycleOwner) { response ->
            binding.progressBar.visibility = View.GONE

            if (response.code() == 200) {
                response.body()?.let {
                    with(binding) {
                        tvName.text = it.hotel_name
                        tvAddress.text = it.hotel_adress
                        tvRate.text = requireContext().getString(
                            R.string.rate_hotel,
                            it.horating.toString(),
                            it.rating_name,
                        )

                        tvFlightFrom.text = it.departure
                        tvCountryCity.text = it.arrival_country
                        tvDate.text = requireContext().getString(
                            R.string.tour_dates,
                            it.tour_date_start,
                            it.tour_date_stop,
                        )

                        // Разные окончания
                        if (it.number_of_nights > 4) {
                            tvNights.text =
                                requireContext().getString(
                                    R.string.amount_of_nights_when_5,
                                    it.number_of_nights.toString(),
                                )
                        } else {
                            tvNights.text =
                                requireContext().getString(
                                    R.string.amount_of_nights_when_2,
                                    it.number_of_nights.toString(),
                                )
                        }

                        tvHotelInDesc.text = it.hotel_name
                        tvRoomInDesc.text = it.room
                        tvNutrition.text = it.nutrition

                        if (it.tour_price.toString().length >= 4) {
                            val priceString = it.tour_price.toString()
                                .splitAtIndex(it.tour_price.toString().lastIndex - 2)

                            tvTourPrice.text =
                                requireContext().getString(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                        } else {
                            tvTourPrice.text =
                                requireContext().getString(
                                    R.string.price,
                                    it.tour_price.toString(),
                                )
                        }

                        if (it.fuel_charge.toString().length >= 4) {
                            val priceString = it.fuel_charge.toString()
                                .splitAtIndex(it.fuel_charge.toString().lastIndex - 2)

                            tvGasPrice.text =
                                requireContext().getString(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                        } else {
                            tvGasPrice.text =
                                requireContext().getString(
                                    R.string.price,
                                    it.fuel_charge.toString(),
                                )
                        }

                        if (it.service_charge.toString().length >= 4) {
                            val priceString = it.service_charge.toString()
                                .splitAtIndex(it.service_charge.toString().lastIndex - 2)

                            tvServicePrice.text =
                                requireContext().getString(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                        } else {
                            tvServicePrice.text =
                                requireContext().getString(
                                    R.string.price,
                                    it.service_charge.toString(),
                                )
                        }

                        val finalPrice = it.tour_price + it.fuel_charge + it.service_charge

                        if (finalPrice.toString().length >= 4) {
                            val priceString = finalPrice.toString()
                                .splitAtIndex(finalPrice.toString().lastIndex - 2)

                            tvToPayPrice.text =
                                requireContext().getString(
                                    R.string.price_for_two_without_from,
                                    priceString.first,
                                    priceString.second,
                                )
                            binding.btnMakeOrder.text = requireContext().getString(
                                R.string.btn_to_pay_for_two,
                                priceString.first,
                                priceString.second,
                            )
                        } else {
                            tvToPayPrice.text =
                                requireContext().getString(
                                    R.string.price,
                                    finalPrice.toString(),
                                )
                            binding.btnMakeOrder.text = requireContext().getString(
                                R.string.btn_to_pay,
                                finalPrice.toString(),
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

        getBookingData()

        binding.btnMakeOrder.setOnClickListener {
            if (emailTextState.value.isEmpty() && numberTextState.value.isEmpty()) {
                if (emailTextState.value.isEmpty()) {
                    emailErrorState.value = true
                }
                if (numberTextState.value.isEmpty()) {
                    numberErrorState.value = true
                }
            }
            if (!emailErrorState.value && !numberErrorState.value) {
                findNavController().navigate(R.id.action_bookingFragment_to_orderSuccessFragment)
            }
        }
    }

    private fun getBookingData() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.getBookingData()
    }
}
