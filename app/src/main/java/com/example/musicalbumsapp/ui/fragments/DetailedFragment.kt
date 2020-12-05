package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
import com.example.musicalbumsapp.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedFragment : Fragment(R.layout.fragment_detailed) {

    private var binding: FragmentDetailedBinding? = null
    //safeargs
    private val args: DetailedFragmentArgs by navArgs()
    //viewModelFactory is not needed if you create viewModel in such way
    private val tracksViewModel: TracksViewModel by viewModels()
    private lateinit var tracksAdapter: TracksAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailedBinding.bind(view)
        val album = args.AlbumDomainModel

        //get sorted relevant track list
        tracksViewModel.getTracksByCollectionName(
                album.artistId,
                album.collectionName ?: "a"
        )
        setupView(album)
        setupRecyclerView()

        //observe state of api response and show it to user
        tracksViewModel.tracksResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Result.Success -> {
                    tracksAdapter.differ.submitList(response.data)
                }
                is Result.Error -> {
                    Toast.makeText(activity, "Error of tracks loading: ${response.message}", Toast.LENGTH_LONG).show()
                }
                is Result.Loading -> {
                }
            }
        }

        )
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

    //set adapter and layout manager to recycler view
    private fun setupRecyclerView() {
        binding?.rvAlbumTracks?.apply {
            tracksAdapter = TracksAdapter()
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = tracksAdapter
        }
    }

    //nullify binding because of different lifecycle of view and fragment
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}