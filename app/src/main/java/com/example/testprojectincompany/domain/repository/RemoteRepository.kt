package com.example.testprojectincompany.domain.repository

import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import retrofit2.Response

interface RemoteRepository {
    suspend fun getHotelData(): Response<HotelModel>
}