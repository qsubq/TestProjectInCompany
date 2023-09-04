package com.example.testprojectincompany.domain.useCase

import com.example.testprojectincompany.data.remoteDataSource.model.booking.BookingModelResponse
import com.example.testprojectincompany.domain.repository.RemoteRepository
import retrofit2.Response

class GetBookingDataUseCase(private val repository: RemoteRepository) {

    suspend fun execute(): Response<BookingModelResponse> {
        return repository.getBookingData()
    }
}
