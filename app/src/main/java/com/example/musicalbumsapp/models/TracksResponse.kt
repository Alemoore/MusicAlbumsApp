package com.example.musicalbumsapp.models

data class TracksResponse(
    val resultCount: Int,
    val results: List<TrackItem>
)