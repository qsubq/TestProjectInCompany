package com.example.testprojectincompany.domain.repository

import com.example.testprojectincompany.data.remoteDataSource.model.booking.BookingModelResponse
import com.example.testprojectincompany.data.remoteDataSource.model.hotel.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.model.room.RoomModel
import retrofit2.Response

interface RemoteRepository {
    suspend fun getHotelData(): Response<HotelModel>
    suspend fun getRoomsData(): Response<RoomModel>
    suspend fun getBookingData(): Response<BookingModelResponse>
}
