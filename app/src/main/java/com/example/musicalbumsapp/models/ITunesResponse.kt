package com.example.musicalbumsapp.models

data class ITunesResponse(
    val resultCount: Int,
    val results: List<AlbumItem>
)