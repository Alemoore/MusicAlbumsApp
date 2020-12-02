package com.example.musicalbumsapp.ui.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
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

    private fun getTracksByCollectionName() {
        viewModelScope.launch {
            val response = repository.getTracksByCollectionName()
            handleTracksResponse(response)
        }
    }

    private fun handleTracksResponse(response: Response<TracksResponse>) {
        if (response.isSuccessful)
            Log.d("ViewModel", response.body().toString())
        else
            Log.d("ViewModel", response.message())
    }
}
