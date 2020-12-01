package com.example.musicalbumsapp.repository

import com.example.musicalbumsapp.api.AlbumsAPIService
import javax.inject.Inject

class AlbumsRepository @Inject constructor(private val api: AlbumsAPIService) {
    suspend fun getAllAlbums() = api.getAllAlbums()
}