package com.example.testprojectincompany.domain.useCase

import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.domain.repository.RemoteRepository
import retrofit2.Response

class GetHotelDataUseCase(private val repository: RemoteRepository) {

    suspend fun execute(): Response<HotelModel> {
        return repository.getHotelData()
    }
}
