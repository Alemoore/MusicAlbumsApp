package com.example.musicalbumsapp.data.repository


import com.example.musicalbumsapp.data.api.TracksAPIService
import com.example.musicalbumsapp.data.models.toDomainModel
import javax.inject.Inject

class TracksRepository @Inject constructor(private val api: TracksAPIService) {
    //execute request and map results to their domain model
    suspend fun getTracksByCollectionName(albumName: String) = api.getTracksByCollectionName(term = albumName)
            .results
            .map { it.toDomainModel() }
}