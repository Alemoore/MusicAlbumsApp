package com.example.musicalbumsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.musicalbumsapp.R
import com.example.musicalbumsapp.databinding.ActivityMainBinding
import com.example.musicalbumsapp.ui.viewmodels.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //viewModelFactory is not needed if you create viewModel in such way
    val viewModel: AlbumsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }
}