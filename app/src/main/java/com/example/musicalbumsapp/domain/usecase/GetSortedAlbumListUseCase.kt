package com.example.musicalbumsapp.domain.usecase

import com.example.musicalbumsapp.data.repository.AlbumsRepository
import com.example.musicalbumsapp.domain.models.AlbumDomainModel
import com.example.musicalbumsapp.util.Result
import java.lang.Exception
import javax.inject.Inject

class GetSortedAlbumListUseCase @Inject constructor(
        private val albumsRepository: AlbumsRepository
) {
    //execute request and sort it alphabetically
    //handle exceptions
    suspend fun execute(searchQuery: String): Result<AlbumDomainModel> = try {
        Result.Success(albumsRepository.searchAlbums(searchQuery).sortedBy { it.collectionName })
    } catch (e: Exception) {
        Result.Error(message = e.message ?: "Unknown reason")
    }

}