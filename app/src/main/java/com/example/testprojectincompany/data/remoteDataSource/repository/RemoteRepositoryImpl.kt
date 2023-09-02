package com.example.testprojectincompany.data.remoteDataSource.repository

import com.example.testprojectincompany.data.remoteDataSource.api.Retrofit
import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.domain.repository.RemoteRepository
import retrofit2.Response

class RemoteRepositoryImpl : RemoteRepository {

    private val api = Retrofit.api
    override suspend fun getHotelData(): Response<HotelModel> {
        return api.getHotelData()
    }
}
