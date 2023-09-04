package com.example.testprojectincompany.domain.useCase

import com.example.testprojectincompany.data.remoteDataSource.model.room.RoomModel
import com.example.testprojectincompany.domain.repository.RemoteRepository
import retrofit2.Response

class GetRoomDataUseCase(private val repository: RemoteRepository) {

    suspend fun execute(): Response<RoomModel> {
        return repository.getRoomsData()
    }
}
