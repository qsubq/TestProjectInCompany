package com.example.testprojectincompany.app.di

import android.content.Context
import com.example.testprojectincompany.app.presentation.screen.room.RoomViewModelFactory
import com.example.testprojectincompany.domain.repository.RemoteRepository
import com.example.testprojectincompany.domain.useCase.GetRoomDataUseCase
import dagger.Module
import dagger.Provides

@Module
class RoomModel {

    @Provides
    fun provideRoomViewModelFactory(
        context: Context,
        getRoomDataUseCase: GetRoomDataUseCase,
    ): RoomViewModelFactory {
        return RoomViewModelFactory(context, getRoomDataUseCase)
    }

    @Provides
    fun provideGetRoomDataUseCase(remoteRepository: RemoteRepository): GetRoomDataUseCase {
        return GetRoomDataUseCase(remoteRepository)
    }
}
