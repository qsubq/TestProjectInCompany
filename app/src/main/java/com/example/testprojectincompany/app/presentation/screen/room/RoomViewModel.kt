package com.example.testprojectincompany.app.presentation.screen.room

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testprojectincompany.data.remoteDataSource.model.RoomModel
import com.example.testprojectincompany.domain.useCase.GetRoomDataUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response

class RoomViewModel(private val context: Application, private val getRoomDataUseCase: GetRoomDataUseCase) :
    AndroidViewModel(context) {

    private val _roomLiveData: MutableLiveData<Response<RoomModel>> = MutableLiveData()
    var roomLiveData: LiveData<Response<RoomModel>> = _roomLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    var errorLiveData: LiveData<String> = _errorLiveData

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.message?.let {
                Log.e("HotelViewModel", it)
                _errorLiveData.value = it
            }
        }

    fun getRoomsData() {
        if (isOnline(context)) {
            viewModelScope.launch(coroutineExceptionHandler) {
                _roomLiveData.value = getRoomDataUseCase.execute()
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
