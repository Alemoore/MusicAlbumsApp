package com.example.musicalbumsapp.data.models

import com.example.musicalbumsapp.domain.models.TrackDomainModel

data class TrackItem(
    val artistId: Int?,
    val artistName: String?,
    val artistViewUrl: String?,
    val artworkUrl100: String?,
    val artworkUrl30: String?,
    val artworkUrl60: String?,
    val collectionCensoredName: String?,
    val collectionExplicitness: String?,
    val collectionId: Int?,
    val collectionName: String?,
    val collectionPrice: Double?,
    val collectionViewUrl: String?,
    val contentAdvisoryRating: String?,
    val country: String?,
    val currency: String?,
    val discCount: Int?,
    val discNumber: Int?,
    val isStreamable: Boolean?,
    val kind: String?,
    val previewUrl: String?,
    val primaryGenreName: String?,
    val releaseDate: String?,
    val trackCensoredName: String?,
    val trackCount: Int?,
    val trackExplicitness: String?,
    val trackId: Int?,
    val trackName: String?,
    val trackNumber: Int?,
    val trackPrice: Double?,
    val trackTimeMillis: Int?,
    val trackViewUrl: String?,
    val wrapperType: String?
)

//map api response to domain model without null fields
fun TrackItem.toDomainModel() = TrackDomainModel(
        artistId = this.artistId ?: Int.MIN_VALUE,
        artistName = this.artistName ?: "Unknown",
        collectionId = this.collectionId ?: Int.MIN_VALUE,
        collectionName = this.collectionName ?: "Unknown",
        collectionPrice = this.collectionPrice ?: Double.MAX_VALUE,
        trackId = this.trackId ?: Int.MAX_VALUE,
        trackName = this.trackName ?: "Unknown",
        trackNumber = this.trackNumber ?: Int.MAX_VALUE,
        trackPrice = this.trackPrice ?: Double.MAX_VALUE

)