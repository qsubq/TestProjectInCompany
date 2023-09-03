package com.example.testprojectincompany.app.presentation.screen.room

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testprojectincompany.domain.useCase.GetRoomDataUseCase

class RoomViewModelFactory(
    private val context: Context,
    private val getRoomDataUseCase: GetRoomDataUseCase,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RoomViewModel(context as Application, getRoomDataUseCase) as T
    }
}
