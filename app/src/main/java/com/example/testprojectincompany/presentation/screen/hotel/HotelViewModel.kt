package com.example.testprojectincompany.presentation.screen.hotel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.repository.RemoteRepositoryImpl
import com.example.testprojectincompany.domain.useCase.GetHotelDataUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class HotelViewModel(private val context: Application) : AndroidViewModel(context) {
    private val getHotelDataUseCase = GetHotelDataUseCase(RemoteRepositoryImpl())

    private val _hotelLiveData: MutableLiveData<Response<HotelModel>> = MutableLiveData()
    var hotelLiveData: LiveData<Response<HotelModel>> = _hotelLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    var errorLiveData: LiveData<String> = _errorLiveData

    fun getHotelData() {
        if (isOnline(context)) {
            viewModelScope.launch {
                _hotelLiveData.value = getHotelDataUseCase.execute()
            }
        } else {
            _errorLiveData.value = "Out of connection"
        }
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)

        return networkCapabilities != null
    }
}
