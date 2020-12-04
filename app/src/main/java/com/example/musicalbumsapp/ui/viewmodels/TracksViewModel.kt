package com.example.musicalbumsapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalbumsapp.domain.models.TrackDomainModel
import com.example.musicalbumsapp.domain.usecase.GetAlbumTracksUseCase
import com.example.musicalbumsapp.util.Result
import kotlinx.coroutines.launch

class TracksViewModel @ViewModelInject constructor(
        private val getAlbumTracksUseCase: GetAlbumTracksUseCase
) : ViewModel() {

    private val _tracksResponse = MutableLiveData<Result<TrackDomainModel>>()
    val tracksResponse: LiveData<Result<TrackDomainModel>> = _tracksResponse


    fun getTracksByCollectionName(artistId: Int, albumName: String) {
        _tracksResponse.postValue(Result.Loading())
        viewModelScope.launch {
            val response = getAlbumTracksUseCase.execute(artistId, albumName)
            if (!response.data.isNullOrEmpty()) {
                _tracksResponse.postValue(Result.Success(response.data))
            } else {
                _tracksResponse.postValue(Result.Error(message = "Result of search is empty"))
            }
        }
    }
}


