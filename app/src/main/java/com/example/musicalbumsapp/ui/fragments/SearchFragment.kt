package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentSearchBinding
import com.example.musicalbumsapp.ui.MainActivity
import com.example.musicalbumsapp.ui.viewmodels.AlbumsViewModel

class SearchFragment: Fragment(R.layout.fragment_search) {

    private lateinit var albumsViewModel: AlbumsViewModel
    private var binding: FragmentSearchBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)
        albumsViewModel = (activity as MainActivity).viewModel
        binding?.searchButton?.setOnClickListener {
            val searchQuery = binding?.etSearchQuery?.text.toString()
            if (searchQuery.isEmpty()) {
                Toast.makeText(activity, "Query is empty, please, enter what you want to find", Toast.LENGTH_SHORT).show()
            } else {
                albumsViewModel.searchAlbums(searchQuery)
                findNavController().navigate(R.id.action_searchFragment_to_albumsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}