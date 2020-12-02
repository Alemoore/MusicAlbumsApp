package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentTracksBinding

class TracksFragment: Fragment(R.layout.fragment_tracks) {

    private var binding: FragmentTracksBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTracksBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}