package com.example.musicalbumsapp.models

import android.os.Parcel
import android.os.Parcelable

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        if (amgArtistId != null) {
            parcel.writeInt(amgArtistId)
        }
        if (artistId != null) {
            parcel.writeInt(artistId)
        }
        parcel.writeString(artistName)
        parcel.writeString(artistViewUrl)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl60)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(collectionExplicitness)
        if (collectionId != null) {
            parcel.writeInt(collectionId)
        }
        parcel.writeString(collectionName)
        if (collectionPrice != null) {
            parcel.writeDouble(collectionPrice)
        }
        parcel.writeString(collectionType)
        parcel.writeString(collectionViewUrl)
        parcel.writeString(contentAdvisoryRating)
        parcel.writeString(copyright)
        parcel.writeString(country)
        parcel.writeString(currency)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
        if (trackCount != null) {
            parcel.writeInt(trackCount)
        }
        parcel.writeString(wrapperType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlbumItem> {
        override fun createFromParcel(parcel: Parcel): AlbumItem {
            return AlbumItem(parcel)
        }

        override fun newArray(size: Int): Array<AlbumItem?> {
            return arrayOfNulls(size)
        }
    }
}