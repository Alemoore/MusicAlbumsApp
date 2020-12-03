package com.example.musicalbumsapp.repository


import com.example.musicalbumsapp.api.TracksAPIService
import javax.inject.Inject

class TracksRepository @Inject constructor(private val api: TracksAPIService) {
    suspend fun getTracksByCollectionName(artistName: String, albumName: String) = api.getTracksByCollectionName(term = albumName)
}