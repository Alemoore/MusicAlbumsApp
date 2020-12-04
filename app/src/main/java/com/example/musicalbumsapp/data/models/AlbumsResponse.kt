package com.example.musicalbumsapp.data.models

data class AlbumsResponse(
    val resultCount: Int,
    val results: List<AlbumItem>
)