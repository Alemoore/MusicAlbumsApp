package com.example.musicalbumsapp.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalbumsapp.models.ITunesResponse
import com.example.musicalbumsapp.repository.AlbumsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AlbumsViewModel @ViewModelInject constructor(
        private val repository: AlbumsRepository
) : ViewModel() {

    private val _albumsResponse = MutableLiveData<ITunesResponse>()
    val albumsResponse: LiveData<ITunesResponse> = _albumsResponse

    init {
        getAllAlbums()
    }

    private fun getAllAlbums() {
        viewModelScope.launch {
            val response = repository.getAllAlbums()
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response<ITunesResponse>) {
        if (response.isSuccessful) {
            _albumsResponse.postValue(response.body())
        } else {
            Log.d("ViewModel", response.message())
        }
    }
}