package com.example.musicalbumsapp.api

import com.example.musicalbumsapp.models.ITunesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumsAPIService {
    @GET("search?")
    suspend fun getAllAlbums(
            @Query("term") term: String = "Classic",
            @Query("media") media: String = "music",
            @Query("entity") entityType: String = "album",
            @Query("attribute") attribute: String = "genreTerm"
    ): Response<ITunesResponse>
}