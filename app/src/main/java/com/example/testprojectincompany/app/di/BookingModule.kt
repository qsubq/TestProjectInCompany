package com.example.testprojectincompany.app.di

import android.content.Context
import com.example.testprojectincompany.app.presentation.screen.booking.BookingViewModelFactory
import com.example.testprojectincompany.domain.repository.RemoteRepository
import com.example.testprojectincompany.domain.useCase.GetBookingDataUseCase
import dagger.Module
import dagger.Provides

@Module
class BookingModule {

    @Provides
    fun provideBookingViewModelFactory(
        context: Context,
        getBookingDataUseCase: GetBookingDataUseCase,
    ): BookingViewModelFactory {
        return BookingViewModelFactory(context, getBookingDataUseCase)
    }

    @Provides
    fun provideGetBookingDataUseCase(repository: RemoteRepository): GetBookingDataUseCase {
        return GetBookingDataUseCase(repository)
    }
}
