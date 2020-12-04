package com.example.musicalbumsapp.data.api

import com.example.musicalbumsapp.data.models.TracksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TracksAPIService {
    @GET("search?")
    suspend fun getTracksByCollectionName(
            @Query("term")term: String,
            @Query("media")media: String = "music",
            @Query("entity")entityType: String = "song",
            @Query("attribute")attribute: String = "albumTerm"
    ): TracksResponse
}