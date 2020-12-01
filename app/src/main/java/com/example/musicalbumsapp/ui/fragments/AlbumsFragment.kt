package com.example.musicalbumsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.ui.AlbumsViewModel
import com.example.musicalbumsapp.ui.MainActivity
import kotlinx.coroutines.launch

class AlbumsFragment: Fragment(R.layout.fragment_albums) {

    private lateinit var viewModel: AlbumsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        viewModel.albumsResponse.observe(viewLifecycleOwner, Observer {
                //Log.d("MyTag", it.albums[0].artistName.toString())
        })
    }

}