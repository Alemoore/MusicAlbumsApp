package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.FragmentAlbumsBinding
import com.example.musicalbumsapp.ui.viewmodels.AlbumsViewModel
import com.example.musicalbumsapp.ui.MainActivity
import com.example.musicalbumsapp.ui.adapters.AlbumsAdapter
import com.example.musicalbumsapp.util.Result

class AlbumsFragment : Fragment(R.layout.fragment_albums) {
    private var binding: FragmentAlbumsBinding? = null
    private lateinit var albumsViewModel: AlbumsViewModel
    private lateinit var albumsAdapter: AlbumsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlbumsBinding.bind(view)
        albumsViewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        albumsAdapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putParcelable("AlbumDomainModel", it)
            findNavController().navigate(R.id.action_albumsFragment_to_detailedFragment, bundle)
        }

        albumsViewModel.albumsResponse.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Result.Success -> {
                    hideProgressBar()
                    albumsAdapter.differ.submitList(response.data)
                }
                is Result.Error -> {
                    hideProgressBar()
                    Toast.makeText(activity, response.message, Toast.LENGTH_LONG).show()
                }
                is Result.Loading -> {
                    showProgressBar()
                }
            }
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

    private fun hideProgressBar() {
        binding?.albumsProgressBar?.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding?.albumsProgressBar?.visibility = View.VISIBLE
    }

}