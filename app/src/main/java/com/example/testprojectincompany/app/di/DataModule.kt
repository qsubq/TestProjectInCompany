package com.example.testprojectincompany.app.di

import com.example.testprojectincompany.data.remoteDataSource.api.Api
import com.example.testprojectincompany.data.remoteDataSource.repository.RemoteRepositoryImpl
import com.example.testprojectincompany.domain.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {
    @Provides
    fun provideRemoteRepository(api: Api): RemoteRepository {
        return RemoteRepositoryImpl(api)
    }

    @Provides
    fun provideApi(): Api {
        val BASE_URL = "https://run.mocky.io"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Api::class.java)
    }
}
