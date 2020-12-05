package com.example.musicalbumsapp.data.api

import com.example.musicalbumsapp.data.models.AlbumsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumsAPIService {
    @GET("search?")
    suspend fun searchAlbums(
            @Query("term") term: String = "Classic",
            @Query("media") media: String = "music",
            @Query("entity") entityType: String = "album",
            @Query("attribute") attribute: String = "genreTerm",
            @Query("limit") limit: String = "20"
    ): AlbumsResponse
}