package com.example.testprojectincompany.app.presentation.screen.hotel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testprojectincompany.domain.useCase.GetHotelDataUseCase

class HotelViewModelFactory(private val context: Context, private val getHotelDataUseCase: GetHotelDataUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HotelViewModel(context as Application, getHotelDataUseCase) as T
    }
}
