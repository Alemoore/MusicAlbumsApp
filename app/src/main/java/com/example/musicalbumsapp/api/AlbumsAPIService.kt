package com.example.musicalbumsapp.api

import com.example.musicalbumsapp.models.AlbumsResponse
import com.example.musicalbumsapp.models.TracksResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumsAPIService {
    @GET("search?")
    suspend fun searchAlbums(
            //убрать поиск по умолчанию
            @Query("term") term: String = "Classic",
            @Query("media") media: String = "music",
            @Query("entity") entityType: String = "album",
            @Query("attribute") attribute: String = "genreTerm",
            @Query("limit") limit: String = "20"
    ): Response<AlbumsResponse>
}