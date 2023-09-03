package com.example.testprojectincompany.domain.repository

import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.model.RoomModel
import retrofit2.Response

interface RemoteRepository {
    suspend fun getHotelData(): Response<HotelModel>
    suspend fun getRoomsData(): Response<RoomModel>
}
