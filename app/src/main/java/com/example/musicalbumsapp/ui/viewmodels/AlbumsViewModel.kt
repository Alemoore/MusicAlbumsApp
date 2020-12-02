package com.example.musicalbumsapp.ui.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalbumsapp.models.AlbumsResponse
import com.example.musicalbumsapp.models.TracksResponse
import com.example.musicalbumsapp.repository.AlbumsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class AlbumsViewModel @ViewModelInject constructor(
        private val repository: AlbumsRepository
) : ViewModel() {

    private val _albumsResponse = MutableLiveData<AlbumsResponse>()
    val albumsResponse: LiveData<AlbumsResponse> = _albumsResponse

    init {
        getAllAlbums()
    }

    private fun getAllAlbums() {
        viewModelScope.launch {
            val response = repository.getAllAlbums()
            handleAlbumsResponse(response)
        }
    }


    private fun handleAlbumsResponse(response: Response<AlbumsResponse>) {
        if (response.isSuccessful) {
            _albumsResponse.postValue(response.body())
        } else {
            Log.d("ViewModel", response.message())
        }
    }
}