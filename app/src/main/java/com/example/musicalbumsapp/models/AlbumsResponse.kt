package com.example.musicalbumsapp.models

data class AlbumsResponse(
    val resultCount: Int,
    val results: List<AlbumItem>
)