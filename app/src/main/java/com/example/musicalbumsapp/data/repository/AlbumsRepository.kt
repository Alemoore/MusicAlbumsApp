package com.example.musicalbumsapp.data.repository

import com.example.musicalbumsapp.data.api.AlbumsAPIService
import com.example.musicalbumsapp.data.models.toDomainModel
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val api: AlbumsAPIService) {
    //execute request and map results to their domain model
    suspend fun searchAlbums(searchQuery: String) =
            api.searchAlbums(term = searchQuery)
                    .results
                    .map { it.toDomainModel() }
}