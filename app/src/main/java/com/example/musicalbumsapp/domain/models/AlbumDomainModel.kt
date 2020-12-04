package com.example.musicalbumsapp.domain.models

import android.os.Parcel
import android.os.Parcelable

data class AlbumDomainModel(
        val artistId: Int,
        val artistName: String?,
        val artworkUrl100: String?,
        val artworkUrl60: String?,
        val collectionId: Int,
        val collectionName: String?,
        val collectionPrice: Double,
        val primaryGenreName: String?,
        val releaseDate: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(artistId)
        parcel.writeString(artistName)
        parcel.writeString(artworkUrl100)
        parcel.writeString(artworkUrl60)
        parcel.writeInt(collectionId)
        parcel.writeString(collectionName)
        parcel.writeDouble(collectionPrice)
        parcel.writeString(primaryGenreName)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlbumDomainModel> {
        override fun createFromParcel(parcel: Parcel): AlbumDomainModel {
            return AlbumDomainModel(parcel)
        }

        override fun newArray(size: Int): Array<AlbumDomainModel?> {
            return arrayOfNulls(size)
        }
    }
}