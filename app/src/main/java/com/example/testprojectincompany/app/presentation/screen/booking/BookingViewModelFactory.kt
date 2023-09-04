package com.example.testprojectincompany.app.presentation.screen.booking

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testprojectincompany.domain.useCase.GetBookingDataUseCase

class BookingViewModelFactory(
    private val context: Context,
    private val getBookingDataUseCase: GetBookingDataUseCase,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookingViewModel(context as Application, getBookingDataUseCase) as T
    }
}
