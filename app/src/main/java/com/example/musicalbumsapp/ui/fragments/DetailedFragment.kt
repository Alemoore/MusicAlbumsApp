package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentDetailedBinding

class DetailedFragment : Fragment(R.layout.fragment_detailed) {
    private var binding: FragmentDetailedBinding? = null
    private val args: DetailedFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailedBinding.bind(view)
        val album = args.AlbumItem
        binding?.apply {
            Glide.with(binding!!.root)
                    .load(album.artworkUrl100)
                    .into(ivAlbumArtwork)

            tvArtistName.text = album.artistName
            tvAlbumTitle.text = album.collectionName
            tvGenre.text = album.primaryGenreName
            tvCurrency.text = album.collectionPrice.toString()
            tvDate.text = album.releaseDate

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}