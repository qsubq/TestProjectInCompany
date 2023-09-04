package com.example.testprojectincompany.app.presentation.screen.booking

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testprojectincompany.data.remoteDataSource.model.booking.BookingModelResponse
import com.example.testprojectincompany.domain.useCase.GetBookingDataUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.Response

class BookingViewModel(
    private val context: Application,
    private val getBookingDataUseCase: GetBookingDataUseCase,
) :
    AndroidViewModel(context) {

    private val _bookingLiveData: MutableLiveData<Response<BookingModelResponse>> =
        MutableLiveData()
    var bookingLiveData: LiveData<Response<BookingModelResponse>> = _bookingLiveData

    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()
    var errorLiveData: LiveData<String> = _errorLiveData

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.message?.let {
                Log.e("HotelViewModel", it)
                _errorLiveData.value = it
            }
        }

    fun getBookingData() {
        if (isOnline(context)) {
            viewModelScope.launch(coroutineExceptionHandler) {
                _bookingLiveData.value = getBookingDataUseCase.execute()
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
