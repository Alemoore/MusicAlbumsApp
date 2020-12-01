package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentAlbumsBinding
import com.example.musicalbumsapp.ui.AlbumsViewModel
import com.example.musicalbumsapp.ui.MainActivity
import com.example.musicalbumsapp.ui.adapters.AlbumsAdapter
import kotlinx.coroutines.launch

class AlbumsFragment: Fragment(R.layout.fragment_albums) {
    private var binding: FragmentAlbumsBinding? = null
    private lateinit var viewModel: AlbumsViewModel
    private lateinit var albumsAdapter: AlbumsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlbumsBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
        viewModel.albumsResponse.observe(viewLifecycleOwner, Observer { response ->
            albumsAdapter.differ.submitList(response.results)
        })
    }

    private fun setupRecyclerView() {
        albumsAdapter = AlbumsAdapter()
        binding?.rvFoundAlbums?.apply {
            adapter = albumsAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}