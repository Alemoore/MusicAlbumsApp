package com.example.musicalbumsapp.data.repository


import com.example.musicalbumsapp.data.api.TracksAPIService
import com.example.musicalbumsapp.data.models.toDomainModel
import javax.inject.Inject

class TracksRepository @Inject constructor(private val api: TracksAPIService) {
    suspend fun getTracksByCollectionName(albumName: String) = api.getTracksByCollectionName(term = albumName)
            .results
            .map { it.toDomainModel() }
}