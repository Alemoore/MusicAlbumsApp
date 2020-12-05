package com.example.musicalbumsapp.domain.usecase

import com.example.musicalbumsapp.data.repository.TracksRepository
import com.example.musicalbumsapp.domain.models.TrackDomainModel
import com.example.musicalbumsapp.util.Result
import java.lang.Exception
import javax.inject.Inject

class GetAlbumTracksUseCase @Inject constructor(
        private val tracksRepository: TracksRepository
) {
    //get only relevant album tracks and sort them by their number
    //handle exceptions
    suspend fun execute(artistId: Int, albumName: String): Result<TrackDomainModel> = try {
        val result = tracksRepository.getTracksByCollectionName(albumName = albumName)
                .filter { it.artistId == artistId && it.collectionName == albumName}
                .sortedBy { it.trackNumber }

        Result.Success(result)
    } catch (e: Exception) {
        Result.Error(message = e.message ?: "Unknown error")
    }
}