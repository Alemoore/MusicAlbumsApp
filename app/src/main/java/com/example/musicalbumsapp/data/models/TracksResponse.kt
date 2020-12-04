package com.example.musicalbumsapp.data.models

data class TracksResponse(
    val resultCount: Int,
    val results: List<TrackItem>
)