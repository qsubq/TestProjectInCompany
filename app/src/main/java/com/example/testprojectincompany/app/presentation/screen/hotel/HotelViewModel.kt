package com.example.testprojectincompany.app.presentation.screen.hotel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testprojectincompany.data.remoteDataSource.model.HotelModel
import com.example.testprojectincompany.data.remoteDataSource.repository.RemoteRepositoryImpl
import com.example.testprojectincompany.domain.useCase.GetHotelDataUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response

class HotelViewModel(val context: Application, val getHotelDataUseCase: GetHotelDataUseCase) : AndroidViewModel(context) {

    private val _hotelLiveData: MutableLiveData<Response<HotelModel>> = MutableLiveData()
    var hotelLiveData: LiveData<Response<HotelModel>> = _hotelLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    var errorLiveData: LiveData<String> = _errorLiveData

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.message?.let {
                Log.e("HotelViewModel", it)
                _errorLiveData.value = it
            }
        }

    fun getHotelData() {
        if (isOnline(context)) {
            viewModelScope.launch(coroutineExceptionHandler) {
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
