package com.example.testprojectincompany.data.remoteDataSource.repository

import com.example.testprojectincompany.data.remoteDataSource.api.Api
import com.example.testprojectincompany.data.remoteDataSource.model.booking.BookingModelResponse
import com.example.testprojectincompany.data.remoteDataSource.model.hotel.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.model.room.RoomModel
import com.example.testprojectincompany.domain.repository.RemoteRepository
import retrofit2.Response

class RemoteRepositoryImpl(private val api: Api) : RemoteRepository {
    override suspend fun getHotelData(): Response<HotelModel> {
        return api.getHotelData()
    }

    override suspend fun getRoomsData(): Response<RoomModel> {
        return api.getRoomData()
    }

    override suspend fun getBookingData(): Response<BookingModelResponse> {
        return api.getBookingData()
    }
}
