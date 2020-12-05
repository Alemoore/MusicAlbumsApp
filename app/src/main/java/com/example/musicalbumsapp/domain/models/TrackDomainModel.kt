package com.example.musicalbumsapp.domain.models

//Domain model if Album
data class TrackDomainModel(
        val artistId: Int,
        val artistName: String,
        val collectionId: Int,
        val collectionName: String,
        val collectionPrice: Double,
        val trackId: Int,
        val trackName: String,
        val trackNumber: Int,
        val trackPrice: Double,
        val trackTimeMinutes: String
)