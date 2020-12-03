package com.example.musicalbumsapp.ui.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalbumsapp.models.TracksResponse
import com.example.musicalbumsapp.repository.AlbumsRepository
import com.example.musicalbumsapp.repository.TracksRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class TracksViewModel @ViewModelInject constructor(
        private val repository: TracksRepository
) : ViewModel() {

    private val _tracksResponse = MutableLiveData<TracksResponse>()
    val tracksResponse: LiveData<TracksResponse> = _tracksResponse


    fun getTracksByCollectionName(artistName: String, albumName: String) {
        viewModelScope.launch {
            val response = repository.getTracksByCollectionName(artistName, albumName)
            handleTracksResponse(response)
        }
    }

    private fun handleTracksResponse(response: Response<TracksResponse>) {
        if (response.isSuccessful)
            _tracksResponse.postValue(response.body())
        else
            Log.d("TracksViewModel", response.message())
    }
}
