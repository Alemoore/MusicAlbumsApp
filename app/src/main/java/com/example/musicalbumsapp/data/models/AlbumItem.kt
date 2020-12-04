package com.example.musicalbumsapp.data.models

import com.example.musicalbumsapp.domain.models.AlbumDomainModel

data class AlbumItem(
        val amgArtistId: Int?,
        val artistId: Int?,
        val artistName: String?,
        val artistViewUrl: String?,
        val artworkUrl100: String?,
        val artworkUrl60: String?,
        val collectionCensoredName: String?,
        val collectionExplicitness: String?,
        val collectionId: Int?,
        val collectionName: String?,
        val collectionPrice: Double?,
        val collectionType: String?,
        val collectionViewUrl: String?,
        val contentAdvisoryRating: String?,
        val copyright: String?,
        val country: String?,
        val currency: String?,
        val primaryGenreName: String?,
        val releaseDate: String?,
        val trackCount: Int?,
        val wrapperType: String?
)

fun AlbumItem.toDomainModel() = AlbumDomainModel(
        artistId = this.artistId ?: 0,
        artistName = this.artistName ?: "Unknown",
        artworkUrl100 = this.artworkUrl100 ?: "",
        artworkUrl60 = this.artworkUrl60 ?: "",
        collectionId = this.collectionId ?: 0,
        collectionName = this.collectionName ?: "Unknown",
        collectionPrice = this.collectionPrice ?: 0.0,
        primaryGenreName = this.primaryGenreName ?: "Unknown",
        releaseDate = this.releaseDate ?: "Unknown"
)