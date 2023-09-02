package com.example.testprojectincompany.data.remoteDataSource.api

import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelData(): Response<HotelModel>
}
