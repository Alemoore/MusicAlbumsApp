package com.example.musicalbumsapp.api

import com.example.musicalbumsapp.models.TracksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TracksAPIService {
    @GET("search?")
    suspend fun getTracksByCollectionName(
            @Query("term")term: String,
            @Query("media")media: String = "music",
            @Query("entity")entityType: String = "song",
            @Query("attribute")attribute: String = "albumTerm"
    ): Response<TracksResponse>
}