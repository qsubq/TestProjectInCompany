package com.example.testprojectincompany.data.remoteDataSource.api

import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.model.RoomModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getHotelData(): Response<HotelModel>

    @GET("/v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getRoomData(): Response<RoomModel>
}
