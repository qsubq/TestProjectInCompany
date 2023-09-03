package com.example.testprojectincompany.app.di

import android.content.Context
import com.example.testprojectincompany.app.presentation.screen.hotel.HotelViewModelFactory
import com.example.testprojectincompany.domain.repository.RemoteRepository
import com.example.testprojectincompany.domain.useCase.GetHotelDataUseCase
import dagger.Module
import dagger.Provides

@Module
class HotelModule {

    @Provides
    fun provideHotelViewModelFactory(
        context: Context,
        getHotelDataUseCase: GetHotelDataUseCase,
    ): HotelViewModelFactory {
        return HotelViewModelFactory(context, getHotelDataUseCase)
    }

    @Provides
    fun provideGetHotelDataUseCase(remoteRepository: RemoteRepository): GetHotelDataUseCase {
        return GetHotelDataUseCase(remoteRepository)
    }
}
