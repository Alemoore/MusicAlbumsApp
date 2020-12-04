package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentDetailedBinding
import com.example.musicalbumsapp.domain.models.AlbumDomainModel
import com.example.musicalbumsapp.ui.adapters.TracksAdapter
import com.example.musicalbumsapp.ui.viewmodels.TracksViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedFragment : Fragment(R.layout.fragment_detailed) {

    private var binding: FragmentDetailedBinding? = null
    private val args: DetailedFragmentArgs by navArgs()
    private val tracksViewModel: TracksViewModel by viewModels()
    private lateinit var tracksAdapter: TracksAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailedBinding.bind(view)
        val album = args.AlbumDomainModel

        tracksViewModel.getTracksByCollectionName(
                album.artistId,
                album.collectionName ?: "abra cadabra"
        )
        setupView(album)
        setupRecyclerView()

        //Сделать по аналогии с альбумс-фрагментом
        tracksViewModel.tracksResponse.observe(viewLifecycleOwner, Observer { response ->
            tracksAdapter.differ.submitList(response.data)
        })
    }

    private fun setupView(album: AlbumDomainModel) {

        binding?.apply {
            Glide.with(binding!!.root)
                    .load(album.artworkUrl100)
                    .into(ivAlbumArtwork)

            tvArtistName.text = album.artistName
            tvAlbumTitle.text = album.collectionName
            tvGenre.text = album.primaryGenreName
            tvCurrency.text = ("$" + album.collectionPrice.toString())
            tvDate.text = album.releaseDate
        }
    }

    private fun setupRecyclerView() {
        binding?.rvAlbumTracks?.apply {
            tracksAdapter = TracksAdapter()
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = tracksAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}