package com.example.musicalbumsapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicalbumsapp.util.Result
import com.example.musicalbumsapp.domain.models.AlbumDomainModel
import com.example.musicalbumsapp.domain.usecase.GetSortedAlbumListUseCase
import kotlinx.coroutines.launch

class AlbumsViewModel @ViewModelInject constructor(
        private val getSortedAlbumListUseCase: GetSortedAlbumListUseCase
) : ViewModel() {

    private val _albumsResponse = MutableLiveData<Result<AlbumDomainModel>>()
    val albumsResponse: LiveData<Result<AlbumDomainModel>> = _albumsResponse

    fun searchAlbums(searchQuery: String) {
        _albumsResponse.postValue(Result.Loading())
        viewModelScope.launch {
            val response = getSortedAlbumListUseCase.execute(searchQuery)
            if (!response.data.isNullOrEmpty()) {
                _albumsResponse.postValue(Result.Success(response.data))
            }  else {
                _albumsResponse.postValue(Result.Error(message = "Result of search is empty"))
            }
        }
    }

}